package com.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.vo.Message;
import com.vo.User;

public class ChatServerThread implements Runnable {
	private User user;
	private Message message;
	private Socket socket;
	private ArrayList<User> userList;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	
	public ChatServerThread() {
 	}

	public ChatServerThread(User user, Message message, Socket socket, ArrayList<User> userList, ObjectOutputStream oos,
			ObjectInputStream ois) {
		super();
		this.user = user;
		this.message = message;
		this.socket = socket;
		this.userList = userList;
		this.oos = oos;
		this.ois = ois;
	}

	// status - WAITING || READY
	@Override
	public void run() {

	}

	public void broadCasting() {
		// 전체 멤버에게
	}

}
