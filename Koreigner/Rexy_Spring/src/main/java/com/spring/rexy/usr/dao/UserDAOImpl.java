package com.spring.rexy.usr.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rexy.usr.vo.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public int getUser(UserVO vo) {
		int isCheck = mybatis.selectOne("getUser", vo);
		return isCheck;
	}
}
