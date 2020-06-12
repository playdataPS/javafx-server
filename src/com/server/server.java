package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import com.biz.UserBiz;

import com.vo.*;

public class server {
	// ������ �ڷ��� - �츮�� vo �� �Ӵٰ�����
	public Vector<User> user;
	User userdata; // vo ��ü ����
	ServerSocket svSocket;
	Socket soc;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public void service() {

		try {
			System.out.println("���� �غ�");
			svSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.err.println("���� �غ��� ���� �߻�");
		}

		while (true) {
			try {
				soc = svSocket.accept();
				System.out.println(soc.getInetAddress() + "�� �����߽��ϴ�.");

				ois = new ObjectInputStream(soc.getInputStream());
				oos = new ObjectOutputStream(soc.getOutputStream());
				String userip = soc.getInetAddress().toString().replace("/", "");
				Thread t = new Thread(new ServerThread(user, userip, ois, oos));
				t.start();
			} catch (IOException e) {
				System.err.println("���� �߻�");
			}
		}
	}

//	public static void main(String[] args) {
//		System.out.println("���� ���񽺸� �մϴ�.");
//		server sv = new server();
//		sv.user = new Vector<User>(2, 1);
//		sv.service();
//	}
}
