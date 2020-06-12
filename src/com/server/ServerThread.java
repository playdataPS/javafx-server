package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import com.vo.*;

public class ServerThread implements Runnable {

	Vector<User> udata;
	User userdata;
	ObjectInputStream ois;
	ObjectOutputStream oos;
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


	// @Override
	public void run() {
		while (!exit) {
			try {
				userdata = (User) ois.readObject();
				// ����� ��ӽ� ���°� �޾ƿ�� �޼ҵ�
				Status state = userdata.getStatus();
				switch (state) {
				case CONNECTED:
					userdata.setOos(oos);
					udata.add(userdata);
					sendConnect();
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