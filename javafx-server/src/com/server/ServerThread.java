package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import com.vo.*;

public class ServerThread implements Runnable {
	// 데이터 자료형
	Vector<User> udata;
	User userdata;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	boolean exit = false;

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

	// @Override
	public void run() {
		// udata = (User)ois.readObject();
		try {
			userdata = (User) ois.readObject();
//						udata = ;
//						udata = (User)ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("udata || " + userdata.getNickname() + "||" + userdata.getIp());
	}
	
	
//	public void run() {
//		// udata = (User)ois.readObject();
////		try {
////			userdata = 
////		} catch (ClassNotFoundException e) {
////			e.printStackTrace();
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		System.out.println("udata || " + userdata.getNickname() + "||" + userdata.getIp());
//	}
}
