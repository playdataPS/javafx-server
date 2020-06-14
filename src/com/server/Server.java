package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.Vector;
import com.biz.UserBiz;


import com.vo.*;

public class Server {

	// 데이터 자료형 - 우리는 vo 로 왓다갓다해
	//public Vector<User> user;
	public ArrayList<User> user;
	User userdata; // vo 객체 생성
	ServerSocket svSocket;
	Socket soc;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public void service() {

		try {

			System.out.println("접속 준비");
			svSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.err.println("서비스 준비중 에러 발생");

		}

		while (true) {
			try {
				soc = svSocket.accept();

        
				// 연결 소켓 객체 생성
				// 닉네임이랑 ip 를 확인해서 넘어가야하는뎅

				System.out.println(soc.getInetAddress() + "가 접속했습니다.");
				String userip = soc.getInetAddress().toString().replace("/", "");
				Thread t = new Thread(new ServerThread(user, userip, soc));
				t.start();
			} catch (IOException e) {
				System.err.println("에러 발생");

			}
		}
	}


//	public static void main(String[] args) {
//		System.out.println("���� ���񽺸� �մϴ�.");
//		server sv = new server();
//		sv.user = new Vector<User>(2, 1);
//		sv.service();
//	}
	public static void main(String[] args) {

		System.out.println("서버 서비스를 켭니다.");
		Server sv = new Server();
		sv.user = new ArrayList<User>();
		
//		sv.user = new User();
		sv.service();
//		UserBiz.get_Nickname(userip);

	}
}
