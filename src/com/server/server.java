package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import com.vo.*;

public class server {
	// ������ �ڷ��� - �츮�� vo �� �Ӵٰ�����
	Vector<User> user;
//	User user; // vo ��ü ����
	ServerSocket svSocket;
	Socket soc;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public void service() {

		try {
			System.out.println("socket start");
			svSocket = new ServerSocket(5555);
			// �г����̶� ip ���� �޾ƿ��� �� ȣ��

			// �ԷµȰ��� db ���� Ȯ��
//			user.getNickname();
//			user.getIp();
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				soc = svSocket.accept();
				// ���� ���� ��ü ����
				// �г����̶� ip �� Ȯ���ؼ� �Ѿ���ϴµ�

				System.out.println(soc.getInetAddress() + "ok");

				ois = new ObjectInputStream(soc.getInputStream());
				oos = new ObjectOutputStream(soc.getOutputStream());

				Thread t = new Thread(new ServerThread(user, ois, oos));
//				Thread t = new Thread(new ServerThread(user));
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("server ok");
		server sv = new server();
		sv.user = new Vector<User>(5, 1);
//		sv.user = new User();
		sv.service();
	}
}
