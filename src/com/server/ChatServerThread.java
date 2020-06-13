package com.server;

import java.net.Socket;
import java.util.ArrayList;

import com.vo.User;

public class ChatServerThread implements Runnable {
	private User user;
	private Socket socket;
	private ArrayList<User> userList;
	
//status - WAITING || READY 
	@Override
	public void run() {
		
		
	}

}
