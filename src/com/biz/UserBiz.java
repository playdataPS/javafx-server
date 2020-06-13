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

	public static boolean getNickIp(User udata) {
		Connection conn = getConnection();
		User ret = new UserDao(conn).getNickIP(udata.getIp());
		if (ret.getNickname() == udata.getNickname()) {
			return true;
		} else {
			return false;
		}
	}

	public static void CheckUser(String ip, String nickname) {
		// 1. ip 유무 체크
		System.out.println("실행");
		Connection conn = getConnection();
		int count = new UserDao(conn).getIP(ip);
		if (count > 0) {
			// 2. 있으면 닉네임 가져오기
			String nick = new UserDao(conn).getNickname(ip);
			System.out.println(nick);
			if (nick.equals(nickname)) {
				System.out.println("같다");
				// room list
				// 3. 있는데 닉네임 같으면 방리스트로
			} else {
				System.out.println("달라");
				// nickname
				// 4. 있는데 닉네임 다르면 다시로그인
			}
		} else {
			System.out.println("없을때");
			int cnt = new UserDao(conn).Insert_AllInfo(ip, nickname);
			System.out.println(cnt);
			// 5. 없으면 insert
		}

	}

	public static void main(String[] args) {
		String nickname = "으네";
//		String nickname = "eunhye";
//		String ip = "192.168.0.249";
		String ip = "192.168.0.249";
//		String ip = "192.168.0.5";
		CheckUser(ip, nickname);
	}
}
