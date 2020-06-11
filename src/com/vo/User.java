package com.vo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;

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
	private boolean state;

	private transient ObjectOutputStream oos;
	private ObjectInputStream ois;

//	public static final int FIRST_CONNECTION = 1;
	// dao -> sql ȣ�� insert
//	public static final int DISCONNECTION = 2;
	// dao -> sql state ����

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String message, int state) {

	}

	// ����� ���� - ��� ������ ���� ������
	public User(int no, String ip, String nickname, int score, boolean state) {
		this.no = no;
		this.ip = ip;
		this.nickname = nickname;
		this.score = score;
		this.state = state;
	}

	public User(String nickname, int state) { // ����� �г���, ���°� ������ ������
//		this()
	}

	public User(String nickname, String ip) { // ó���� �г����̶� ip ������ ����������
		this.nickname = nickname;
		this.ip = ip;
		// insert �� �̶� �������
		// dao ȣ��
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
