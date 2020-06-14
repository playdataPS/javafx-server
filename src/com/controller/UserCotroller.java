package com.controller;

import java.util.Scanner;
import java.util.Vector;

import com.biz.UserBiz;
import com.server.Server;
import com.vo.*;

public class UserCotroller {
	Vector<User> user;

	public static void main(String[] args) {
		int r = 0; // �ʱ�ȭ
		do {
			System.out.println("choice ");
			Scanner sc = new Scanner(System.in);
			int no = sc.nextInt();
			r = no;
			switch (r) {
			case 1:
				// ���� ����
				Server sv = new Server();
				System.out.println("1");
				sv.user = new Vector<User>(2, 1);
				sv.service();
				break;
			case 2:
				String aa = UserBiz.getNickname("192.168.0.249");
				System.out.println("get_Nickname " + aa);
				break;
			case 3:
//				UserBiz.CheckUser("192.);
				break;
			case 4:
				// �α��� ���� (�г��Ӱ� ip ��ġ) - ��ü ���� �� ���� ����
				break;
			case 5:
				// �α��� ����(�г��Ӱ� ip ����ġ)
				break;
			case 6:
				// ȸ������ - insert �Լ�
				break;
			}
		} while (r != 999);

	}

//	public static void Select(String select) {
//		switch (select) {
//		case "ckUser":
//			System.out.println("체크");
//			break;
//		}
//	}
}
