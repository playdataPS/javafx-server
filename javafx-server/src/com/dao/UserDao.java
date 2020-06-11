package com.dao;

import java.sql.*;
import static common.JDBCTemplate.*;

public class UserDao implements UserSql {
	private Connection conn;

	public UserDao(Connection conn) {
		this.conn = conn;
	}

	// �г����� ������ 1, ������ 0 ����ϴ� �޼ҵ�
	public String get_Nickname(String ip) {
		PreparedStatement pstm = null;
		ResultSet res = null;
//		int rs = 0;
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
}