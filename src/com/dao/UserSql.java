package com.dao;

import static common.JDBCTemplate.Close;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vo.User;

public interface UserSql {
	//ip 존재 확인
	String ch_ip = "SELECT IP FROM MPJ.GAME_USER WHERE IP = ?";
	//닉네임체크
	String ch_nick = "select nickname from MPJ.GAME_USER \r\n" + "where ip = ?";
	String insert_allinfo = "Insert into MPJ.GAME_USER(no, ip, nickname) \r\n" + "values(MPJ.num_seq.nextval,?, ?)";
	String ch_nickip = "select nickname from MPJ.GAME_USER where ip=?";

}
