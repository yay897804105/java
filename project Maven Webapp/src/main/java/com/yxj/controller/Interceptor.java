package com.yxj.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yxj.po.User;
import com.yxj.service.UserServer;

public class Interceptor extends HandlerInterceptorAdapter {



	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Cookie[] cookie=request.getCookies();
		for(Cookie c:cookie) {
			if(c.getName()=="username") {
				return true;
			}
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}
}
