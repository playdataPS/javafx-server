package com.biz;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import com.dao.UserDao;

public class UserBiz {
	public static String get_Nickname(String ip) {
		Connection conn = getConnection();
		System.out.println("연결됌");
		String ret = new UserDao(conn).get_Nickname(ip);
		Close(conn);
		System.out.println("연결끝");
		return ret;
	}
}
