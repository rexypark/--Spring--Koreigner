package com.spring.rexy.usr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.rexy.usr.service.UserServiceImpl;
import com.spring.rexy.usr.vo.UserVO;

@Controller("userController")
public class UserControllerImpl implements UserController {
	@Autowired
	private UserServiceImpl userService;
	
	@Override
	@RequestMapping("login.do")
	public ModelAndView getUser(UserVO vo, ModelAndView mav) {
		
		System.out.println("vo.getId() : " + vo.getId());
		System.out.println("vo.getPwd() : " + vo.getPwd());
		int isChecked = userService.getUser(vo);
		System.out.println(isChecked);
		
		if(isChecked == 0) {
			System.out.println("로그인을 실패하였습니다");
			mav = new ModelAndView("/views/login.jsp");
		} else {
			System.out.println("로그인을 성공하였습니다.");
			mav = new ModelAndView("/views/login.jsp");
		}
		return mav;
	}
}
