package com.spring.biz.user.impl;

public class UserDAOSpring {

	//SQL 명령어들
	private final String USER_GET
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	private final String USER_LIST
		= "SELECT * FROM USERS ORDER BY ID";
	
	//INSERT, UPDATE, DELETE
	private final String USER_INSERT
		= "INSERT INTO USERS VALUE (?, ?, ?, ?)";
	private final String USER_UPDATE
		= "UPDATE USERS SET PASSWORD = ? WHERE ID = ?";
	private final String USER_DELETE
		= "DELETE FROM USERS WHERE ID = ?";
	
}
