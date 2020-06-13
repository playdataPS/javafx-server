package com.vo;

import java.util.List;

public class Room {
	private int no;//방번호
	private List<User> userList;//유저 리스트 
	private User roomOwner;//방장
	private String title;//방이름
	private RoomStatus status;//방상태 
	private int MaxSize;
}
