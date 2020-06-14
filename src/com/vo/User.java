package com.vo;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int no;
	private String ip;
	private String nickname;
	private int score;
	private Date regdate;
	private transient ObjectOutputStream oos;
	private Status status;
	private int roomNo;
	private String Message;
	private MessageType type;
	private ArrayList<User> userList;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User(String ip, String nickname, Status status, ObjectOutputStream oos) {
		this.ip = ip;
		this.nickname = nickname;
		this.status = status;
		this.oos = oos;

	}

	public User(String ip, String nickname, Status status) {
		this(ip, nickname, status, null);
	}

	public User(String message) {
		super();
		Message = message;
	}

	public User(String ip, String nickname) {
		super();
		this.ip = ip;
		this.nickname = nickname;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}

	/**
	 * @return the type
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(MessageType type) {
		this.type = type;
	}

	/**
	 * @return the userList
	 */
	public ArrayList<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the oos
	 */
	public ObjectOutputStream getOos() {
		return oos;
	}

	/**
	 * @param oos the oos to set
	 */
	public void setOos(ObjectOutputStream oos) {
		this.oos = oos;
	}

}
