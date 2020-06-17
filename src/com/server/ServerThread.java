package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

import com.biz.UserBiz;
import com.controller.GameController;
import com.vo.*;

public class ServerThread implements Runnable {

	List<User> userList; // 소켓 킨 유저들 목록
	User userdata;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	Socket socket;
	boolean exit = false;
	String userip = "";
	int cnt;

	public ServerThread(ArrayList<User> user, ObjectInputStream ois, ObjectOutputStream oos) {
		this.userList = user;
		this.ois = ois;
		this.oos = oos;
	}

	public ServerThread() {
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
					// login

					// userdata = new UserBiz().getLoginUser(userdata);
					System.out.println("CONNECTED");
					List<User> tmp = new ArrayList<User>();

					userList.add(userdata);
					for (User data : userList) {
						tmp.add(data);
//						System.out.println("userList"+data.getNickname());

					} // for end
					
					userdata.setUserList(tmp);
					userdata.setRoomStatus(RoomStatus.WAITING);
					userdata.setStatus(Status.CONNECTED); // 방으로 넘어감
					userdata.setOos(oos);
					System.out.println("tmp size "+tmp.size());
					broadCasting();
					break;
				
				case PLAYING:
					System.out.println("게임 시작함");
					Queue<Game> que = createGameQue();
					Game gameData = que.poll();
					String seekerName = gameData.getSeeker().getNickname();
					for (User u : userList) {
						u.setGameData(gameData);
						if (u.getNickname().equals(seekerName)) {
							u.setGameStatus(GameStatus.SEEK);
						} else {
							u.setGameStatus(GameStatus.HIDE);
						}
					}

					userdata.setGameData(gameData);
					userdata.setGameQue(que);
					if (seekerName.equals(userdata.getNickname())) {
						userdata.setGameStatus(GameStatus.SEEK);
					} else {
						userdata.setGameStatus(GameStatus.HIDE);
					}

					for (User u : userdata.getUserList()) {
						System.out.println(u.getNickname() + " : " + u.getGameStatus());
					}
					broadCasting();

					break;
					
				case ROBY:
					RoomStatus roomstatus = userdata.getRoomStatus();
					if(roomstatus==null)	roomstatus = RoomStatus.WAITING;
					switch (roomstatus) {
					case READY:
						
						for (User u : userList) {
							if (u.getNickname().equals(userdata.getNickname())) {
								u.setRoomStatus(RoomStatus.READY);
							}
							if (u.getRoomStatus().equals(RoomStatus.READY)) {
								cnt++;
							}

						}//for end 


						System.out.println("game count : " + cnt);
						if (cnt > 1 && cnt == userList.size()) {
							// 게임 시작
							System.out.println("game start all");
							userdata.setStatus(Status.PLAYING);
							for (User u : userList) {
								u.setStatus(Status.PLAYING);
							} // for end

						}// if end  
						
						
						break;
					
						
					case WAITING:
						//userdata.setRoomStatus(RoomStatus.WAITING);

						for (User u : userList) {
							if (u.getNickname().equals(userdata.getNickname())) {
								u.setRoomStatus(RoomStatus.WAITING);
								break;
							}
						} // for end
						break;
					
					}
					
					broadCasting();
					break;
					
				case DISCONNECTED:
					System.out.println("DISCONNECTED");
					String name = userdata.getNickname();

					for (User u : userList) {
						if (u.getNickname().equals(name)) {
							userList.remove(u);
							break;
						}
					} // for end
					broadCasting();

					try {
						ois.close();
						oos.close();
						socket.close();
						exit = true;
					} catch (Exception e) {
						e.printStackTrace();
					} // try~catch end
					break;

				case CHAT:
					System.out.println("CHAT 상태");
					userdata.setStatus(Status.CHAT);
					boardChating();

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

	public Queue<Game> createGameQue() {
		List<User> tmp = this.userList;
		List<String> dict = new ArrayList<String>();
		dict.add("연장전");
		dict.add("죽부인");
		dict.add("마법사");
		dict.add("부동산");
		dict.add("두바이");
		dict.add("달팽이");
		dict.add("오이도");
		dict.add("감자탕");
		dict.add("대기층");

		Queue<Game> gameQue = new LinkedList<Game>();
		Collections.shuffle(dict);
		Collections.shuffle(tmp);

		for (int i = 0; i < userList.size(); i++) {
			Game gameData = new Game();
			gameData.setSeeker(tmp.get(i));
			gameData.setWord(dict.get(i));
			List<User> tmp2 = tmp;
			tmp2.remove(i);
			gameData.mixDrowingUser(tmp2);

			gameQue.add(gameData);
		}

		return gameQue;
	}// createGameQue() end

	public void broadCasting() {// 전체 데이터를 보내줌

		// 전체 채팅 회원에게 내용 출력
		for (User data : userList) {
			try {
				data.getOos().writeObject(userdata);
			} catch (IOException e) {
				System.out.println("broadCasting() " + data.getOos() + " userdata " + userdata.getUserList());
				e.printStackTrace();
			}

		} // for end
	}

	public void boardChating() {

		String nickName = userdata.getNickname();
		String message = userdata.getMessage();
		String Content = userdata.getNickname() + ":" + userdata.getMessage();

		for (User data : userList) {
			try {
				data.getOos().writeObject(userList);
				System.out.println("성공햇어요 !!!! nickName" + nickName + "||" + "message " + message);
				System.out.println("모두에게 뿌립니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("nickName" + nickName + "||" + "message " + message);
		// 전체 회원에게 내용 출력
	}

			} catch (IOException e) {
				System.out.println("broadCasting() " + data.getOos() + " userdata " + userdata.getUserList());
				e.printStackTrace();
			}

		} // for end
	}
}