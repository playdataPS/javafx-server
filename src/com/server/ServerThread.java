package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import com.vo.*;

public class ServerThread implements Runnable {

	Vector<User> udata;
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

	public ServerThread() {
	}

	public ServerThread(Vector<User> user) {
		this.udata = user;
	}

	public ServerThread(User user) {
		this.userdata = user;
	}

	public ServerThread(Vector<User> user, String userip, ObjectInputStream ois2, ObjectOutputStream oos2) {
		this.udata = user;
		this.userip = userip;
		this.ois = ois2;
		this.oos = oos2;
	}
	
	public ServerThread(Vector<User> user, String userip, Socket socket) {
		this.udata = user;
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
					userdata.setOos(oos);
					udata.add(userdata);
					
					sendConnect();
					break;
				case WAITING:
					System.out.println(userdata.getNickname());
					System.out.println(userdata.getGameRoom().getTitle());
					Thread x = new Thread(new RoomThread( userdata.getGameRoom(), socket));
					x.start();
					break;
				default:
					System.out.println("error");
					break;

				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("udata || " + userdata.getNickname() + "||" + userip);
	}

	// connect check & send to client
	public void sendConnect() {
		try {
			userdata.getOos().writeObject(userdata);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("udata || " + userdata.getNickname() + "||" + userip);


	}
}