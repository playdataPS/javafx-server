package com.biz;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import com.dao.UserDao;

public class UserBiz {
	public static String get_Nickname(String ip) {
		Connection conn = getConnection();
		System.out.println("�����");
		String ret = new UserDao(conn).get_Nickname(ip);
		Close(conn);
		System.out.println("���᳡");
		return ret;
	}
}
