package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.vo.RoomStatus;
import com.vo.User;

public class RoomThread implements Runnable{
	private int no;//방번호
	private List<User> userList;//유저 리스트 
	private User roomOwner;//방장
	private String title;//방이름
	private RoomStatus status;//방상태 
	private int MaxSize;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public RoomThread() {
		// TODO Auto-generated constructor stub
	}
	
	public RoomThread(User roomOwner, int no, ObjectInputStream ois, ObjectOutputStream oos) {
		this.roomOwner = roomOwner;
		this.no = no;
		this.ois = ois;
		this.oos = oos;
		userList = new ArrayList<User>();
	}
	
	public RoomThread(User roomOwner, int no) {
		this.roomOwner = roomOwner;
		this.no = no;
	}
	
	@Override
	public void run() {
		
		
	}

	public void broadCast() {//유저리스트 
		for(User user: userList) {
			try {
				user.getOos().writeObject(this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //유저들의 상태
		}
	}
	
	public void enterRoom() {
		
	}


	public int getNo() {
		return no;
	}



	public void setNo(int no) {
		this.no = no;
	}



	public List<User> getUserList() {
		return userList;
	}



	public void setUserList(List<User> userList) {
		this.userList = userList;
	}



	public User getRoomOwner() {
		return roomOwner;
	}



	public void setRoomOwner(User roomOwner) {
		this.roomOwner = roomOwner;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public RoomStatus getStatus() {
		return status;
	}



	public void setStatus(RoomStatus status) {
		this.status = status;
	}



	public int getMaxSize() {
		return MaxSize;
	}



	public void setMaxSize(int maxSize) {
		MaxSize = maxSize;
	}




	
	

}
