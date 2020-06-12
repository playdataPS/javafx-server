package com.dao;

public interface UserSql {
	String ch_nick = "select nickname from GAME_USER \r\n" + "where ip = ?";
	String insert_allinfo = "Insert into GAME_USER(no, ip, nickname) \r\n" + "values(num_seq.nextval,?, ?)";
	String ch_nickip = "select nickname from GAME_USER where ip=?";
}
