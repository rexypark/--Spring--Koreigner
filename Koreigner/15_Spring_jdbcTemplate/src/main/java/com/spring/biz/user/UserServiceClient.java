package com.spring.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		//1. 스프링컨테이너 구동
		AbstractApplicationContext container
			= new GenericXmlApplicationContext("applicationContext.xml");
		
		System.out.println("\n === 컨테이너 구동 후 ===");
		//2. 스프링컨테이너에 생성된 객체 요청 및 사용
		UserService userService
			= (UserService) container.getBean("userService");
		
		UserVO uservo = new UserVO();
		uservo.setId("test");
		uservo.setPassword("test");
		System.out.println(uservo.getId());
		
		//2-1. 유저 호출
		UserVO vo = 
				userService.getUser(uservo);
		
		System.out.println("===================");
		System.out.println("userVO : " + vo.getName());
		 
		//3. 컨테이너 종료(close)
		container.close();
	}
}
