package com.spring.rexy.usr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rexy.usr.dao.UserDAOImpl;
import com.spring.rexy.usr.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAOImpl userDAOImp;
	
	@Override
	public int getUser(UserVO vo) {
		int isCheck = userDAOImp.getUser(vo);
		return isCheck;
	}
}
