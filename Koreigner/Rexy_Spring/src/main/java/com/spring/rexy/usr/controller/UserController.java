package com.spring.rexy.usr.controller;

import org.springframework.web.servlet.ModelAndView;

import com.spring.rexy.usr.vo.UserVO;

public interface UserController {
	ModelAndView getUser(UserVO vo, ModelAndView mav);
	

}
