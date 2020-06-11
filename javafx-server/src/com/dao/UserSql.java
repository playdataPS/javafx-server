package com.dao;

public interface UserSql {
	String ch_nick = "select nickname from GAME_USER \r\n" + "where ip = ?";
}
