package com.vo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4894838140464962804L;
	private int no;
	private String ip; 
	private String nickname;
	private int score;
	private Date regdate;
	private transient ObjectOutputStream oos;
	private Status status;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
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

}
