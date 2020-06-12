package com.controller;

import java.util.Scanner;
import java.util.Vector;

import com.biz.UserBiz;
import com.server.server;
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
				server sv = new server();
				System.out.println("1");
				sv.user = new Vector<User>(2, 1);
				sv.service();
				break;
			case 2:
				System.out.println("����");
				String aa = UserBiz.getNickname("192.168.0.249");
				System.out.println("get_Nickname �����߾�" + aa);
				// ip �� ��Ī�Ǵ� �г��� �� ��������
				break;
			case 3:
				// ip �� �г��� ��
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
}
