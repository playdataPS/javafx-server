package com.server;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.vo.User;
/*
 * 방 생성, 삭제, 방리스트 
 * 방장 정보, 방장 교체 
 * 현재 방 크기
 * 방의 상태(waiting / playing)  
 * 
 * */
public class RoomManager {
	private static List roomList;// 방리스트는 한개만 
	private static AtomicInteger atomicInteger;
	
	static {
        roomList = new ArrayList();
        atomicInteger = new AtomicInteger();
    }
	
	public RoomManager() {
		
	}
	
	public void createRoom(User roomOwner) {
		int roomNo = atomicInteger.incrementAndGet();
		
		Thread t = new Thread(new RoomThread(roomOwner, roomNo));
		t.start();
	}
	
	
}
