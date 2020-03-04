package com.spring.biz.user;

import java.util.List;

public interface UserService {

	//CRUD 기능 구현 메소드 정의
	//public abstract UserVO getUser(UserVO vo);
	UserVO getUser(UserVO vo);
	
	default void insertUser (UserVO vo) {}
	default void updateUser (UserVO vo) {}
	default void deleteUser (UserVO vo) {}
	default List<UserVO> getUserList() {return null;}
}
