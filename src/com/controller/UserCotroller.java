package com.controller;

import java.util.Scanner;
import java.util.Vector;

import com.biz.UserBiz;
import com.server.server;
import com.vo.*;

public class UserCotroller {
	Vector<User> user;

	public static void main(String[] args) {
		int r = 0; // 초기화
		do {
			System.out.println("선택하세요");
			Scanner sc = new Scanner(System.in);
			int no = sc.nextInt();
			r = no;
			switch (r) {
			case 1:
				// 서버 실행
				server sv = new server();
				System.out.println("1");
				sv.user = new Vector<User>(2, 1);
				sv.service();
				break;
			case 2:
				System.out.println("선택");
				String aa = UserBiz.getNickname("192.168.0.249");
				System.out.println("get_Nickname 실행했어" + aa);
				// ip 에 매칭되는 닉네임 값 가져오기
				break;
			case 3:
				// ip 와 닉네임 비교
				break;
			case 4:
				// 로그인 성공 (닉네임과 ip 일치) - 객체 생성 후 대기방 입장
				break;
			case 5:
				// 로그인 실패(닉네임과 ip 불일치)
				break;
			case 6:
				// 회원가입 - insert 함수
				break;
			}
		} while (r != 999);

	}
}
