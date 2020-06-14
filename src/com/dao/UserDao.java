package com.dao;

import java.sql.*;

import com.vo.User;

import static common.JDBCTemplate.*;

public class UserDao implements UserSql {
	private Connection conn;

	public UserDao(Connection conn) {
		this.conn = conn;
	}

	// IP �� ���� Ȯ��
	public String getIP(String ip) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User userdata = null;
		String userip = "";
		try {
			pstm = conn.prepareStatement(ch_ip);
			pstm.setString(1, ip);
			rs = pstm.executeQuery();
			while (rs.next()) {
				//userdata = new User(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			Close(rs);
			Close(pstm);
		}
		return userip;
	}

	// �г����� ���� ����ϴ� �޼ҵ�
	public String getNickname(String ip) {
		PreparedStatement pstm = null;
		ResultSet res = null;
		String ret = "";
		try {
			pstm = conn.prepareStatement(ch_nick);
			pstm.setString(1, ip);
			res = pstm.executeQuery();
			while (res.next()) {
				ret = res.getString(1);
				System.out.println(ret);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			Close(res);
			Close(pstm);
		}
		return ret;
	}

	// ip �� �г��� ȣ��
	public User getNickIP(String ip) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User vo = null;

		try {
			pstm = conn.prepareStatement(ch_nickip);
			pstm.setString(1, ip);
			rs = pstm.executeQuery();
			while (rs.next()) {
				vo = new User(rs.getString(1), rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			Close(rs);
			Close(pstm);
		}

		return vo;
	}

	public int Insert_AllInfo(String ip, String nick) {
		int ret = 0;
		PreparedStatement pstm = null;
		return ret;

	}
}
