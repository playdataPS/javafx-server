package com.biz;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import com.dao.UserDao;
import com.vo.User;

public class UserBiz {
	public static String getNickname(String ip) {
		Connection conn = getConnection();
		System.out.println("연결됌");
		String ret = new UserDao(conn).getNickname(ip);
		Close(conn);
		System.out.println("연결끝");
		return ret;
	}

	// 닉네임, ip 모두 입력받아서 일치하는지 확인
	public static boolean getNickIp(User udata) {
		Connection conn = getConnection();
		User ret = new UserDao(conn).getNickIP(udata.getIp());
		if (ret.getNickname() == udata.getNickname()) {
			return true;
		} else {
			return false;
		}
	}

	// ip 없으면 지금 입력한 닉네임, ip 입력
}
