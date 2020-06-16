package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.biz.UserBiz;
import com.vo.*;

public class ServerThread implements Runnable {

	Vector<User> udata;
	List<User> userList;
	User userdata;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Socket socket;
	boolean exit = false;
	String userip = "";
	

	public ServerThread(Vector<User> user, ObjectInputStream ois, ObjectOutputStream oos) {
		this.udata = user;
		this.ois = ois;
		this.oos = oos;
	}
	public ServerThread(ArrayList<User> user, ObjectInputStream ois, ObjectOutputStream oos) {
		this.userList = user;
		this.ois = ois;
		this.oos = oos;
	}

	public ServerThread() {
	}

	public ServerThread(Vector<User> user) {
		this.udata = user;
	}

	public ServerThread(User user) {
		this.userdata = user;
	}

	
	public ServerThread(ArrayList<User> user, String userip, Socket socket) {
		this.userList = user;
		this.userip = userip;
		this.socket = socket;
		try {
			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	// @Override
	public void run() {
		while (!exit) {
			try {
				userdata = (User) ois.readObject();
				Status state = userdata.getStatus();
				System.out.println(state);
				switch (state) {
				case CONNECTED:
					//login 
					
					//userdata = new UserBiz().getLoginUser(userdata);
					System.out.println("CONNECTED");
					List<User> users = new ArrayList<User>();
					userdata.setOos(oos);
					userList.add(userdata);
					for(User data: userList) {
						users.add(data);
					}//for end 
					userdata.setUserList(users);
					userdata.setStatus(Status.WAITING); //방으로 넘어감 
					broadCasting();
					break;
				case WAITING: //방에 들어옴 
					System.out.println("WAITING");
					break;
				
				case READY:
					int cnt = 0;
					for(User u : userList) {
						if(u.getStatus().equals(Status.READY)) {
							cnt++;
						}
					}
					if(cnt>1&&cnt==userList.size()) {
						//게임 시작 
						for(User u : userList) {
							u.setStatus(Status.PLAYING);
						}//for end 
						broadCasting();
					}// if end 
					
					break;
				case PLAYING:
					
					
					break;
				case DISCONNECTED:
					System.out.println("DISCONNECTED");
					String name = userdata.getNickname();
					
					for(User u: userList) {
						if(u.getNickname().equals(name)) {
							userList.remove(u);
							break;
						}
					}//for end 
					broadCasting();
					
					try {
						ois.close();
						oos.close();
						socket.close();
						exit = true;
					}catch (Exception e) {
						e.printStackTrace();
					}//try~catch end
					break;
				default:
					System.out.println("error");
					break;

				}

			} catch (ClassNotFoundException e) {
				exit = true;
				e.printStackTrace();
			} catch (IOException e) {
				exit = true;
				e.printStackTrace();
			}
		}

		System.out.println("udata || " + userdata.getNickname() + "||" + userip);
	}
	public void broadCasting() {//전체 데이터를 보내줌 

		//전체 채팅 회원에게 내용 출력 
		for(User data : userList) {
			try {
				data.getOos().writeObject(userdata);
				
			} catch (IOException e) {
				System.out.println("broadCasting() "+data.getOos()+" userdata "+userdata.getUserList());
				e.printStackTrace();
			}
			
		}//for end 
	}
	
}