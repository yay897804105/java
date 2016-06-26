package com.yxj.controller;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yxj.po.User;
import com.yxj.redis.Redis;
import com.yxj.service.UserServer;
import com.yxj.service.UserServerImpl;

@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	@Qualifier("userServerImpl")
	private UserServer userServerImpl;
	
	@Autowired
	@Qualifier("redisImpl")
	private Redis redis;
	
	@RequestMapping(value="/user/login.action")
	public ModelAndView login (@RequestParam("username") String username,@RequestParam ("password") String password ,HttpServletRequest request , HttpServletResponse response) {
	
		ModelAndView model=new ModelAndView();
		User user= userServerImpl.findUserByUsername(username);
		if(user==null) {
			model.addObject("message", "用户不存在");
			model.setViewName("/login.jsp");

		} else {
			Cookie cookie = new Cookie("username", username);
			response.addCookie(cookie);
			redis.setAttribute(user);
			model.setViewName("/sucess.jsp");

		}
		return model;
	}
	
	@RequestMapping(value="/user/addUser.action")
	public ModelAndView addUser(@RequestParam("username") String username,@RequestParam ("password") String password){
		ModelAndView m=new ModelAndView();
		User user=userServerImpl.findUserByUsername(username);
		if(user!=null) {
			m.addObject("register", "该用户已存在");
			m.setViewName("/register.jsp");
		} else {
			int num = userServerImpl.getNum();
			User user2=new User(username, password);
			user2.setId(num);
			userServerImpl.addUser(user2);
			m.addObject("message", "注册成功");
			m.setViewName("/login.jsp");
		}
		return m;
		
	}
	
	@RequestMapping(value="/user/register.action")
	public ModelAndView register() {
		ModelAndView m=new ModelAndView();
		m.setViewName("/register.jsp");
		return m;
	}

}
