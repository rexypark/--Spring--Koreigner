package com.spring.biz.user.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardRowMapper;
import com.spring.biz.user.UserVO;

@Repository("userDAOSpring")
public class UserDAOSpring{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL 명령어들
	private final String USER_GET
	= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	private final String USER_LIST
	= "SELECT * FROM USERS ORDER BY USERID";

	//INSERT, UPDATE, DELETE
	private final String USER_INSERT = 
			"INSERT INTO USERS VALUES(?, ?, ?, ?)";
	private final String USER_UPDATE = 
			"UPDATE USERS SET PASSWORD = ? WHERE ID = ?";
	private final String USER_DELETE = 
			"DELETE FROM USERS WHERE ID = ?";
	
	
	public UserVO getUser(UserVO vo) {
		System.out.println("====> Spring JDBC로 updateBoard() 실행");
		
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
	
	
	public void insertUser(UserVO vo) {
		System.out.println("===> Spring JDBC로 insertUser() 실행");
		Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
		jdbcTemplate.update(USER_INSERT, args);
	}
	
	
	//글 수정
	public void updateUser(UserVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 실행");
		jdbcTemplate.update(USER_UPDATE, vo.getPassword(), vo.getId());
	}
	
	public void deleteUser(UserVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 실행");
		jdbcTemplate.update(USER_DELETE, vo.getId());
	}
	
	
	public List<UserVO> getUserList() {
		System.out.println("===> Spring JDBC로 getBoardList() 실행");
		
		return jdbcTemplate.query(USER_LIST, 
				new UserRowMapper());
	}
}
