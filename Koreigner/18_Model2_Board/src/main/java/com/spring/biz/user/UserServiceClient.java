package com.spring.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.user.impl.UserDAO;

public class UserServiceClient {
	public static void main(String[] args) {
		/*
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		System.out.println("vo: " + vo);
		
		UserVO user = dao.getUser(vo);
		System.out.println("user: " + user);
		*/
		System.out.println("===== 스프링 프레임워크 사용 =======");
		//1. 스프링컨테이너 구동
		AbstractApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("\n--- 컨테이너 구동후 ----");
		//2. 스프링컨테이너에 생성된 객체 요청 및 사용
		UserService userService
			= (UserService) container.getBean("userService");
		
		//2-1. 입력
		UserVO vo = new UserVO();
		vo.setId("user1");
		vo.setPassword("user1");
		System.out.println("vo: " + vo);
		
		//유저 1명 조회
		System.out.println("==============");
		UserVO user = userService.getUser(vo);
		System.out.println("user: " + user);
		
		//3. 컨테이너 종료(close)
		container.close();

	}

}









