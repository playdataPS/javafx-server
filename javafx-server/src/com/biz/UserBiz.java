package com.biz;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import com.dao.UserDao;
import com.vo.User;

public class UserBiz {
	public static String getNickname(String ip) {
		Connection conn = getConnection();
		System.out.println("�����");
		String ret = new UserDao(conn).getNickname(ip);
		Close(conn);
		System.out.println("���᳡");
		return ret;
	}

	// �г���, ip ��� �Է¹޾Ƽ� ��ġ�ϴ��� Ȯ��
	public static boolean getNickIp(User udata) {
		Connection conn = getConnection();
		User ret = new UserDao(conn).getNickIP(udata.getIp());
		if (ret.getNickname() == udata.getNickname()) {
			return true;
		} else {
			return false;
		}
	}

	// ip ������ ���� �Է��� �г���, ip �Է�
}
