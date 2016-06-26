package com.yxj.service;

import com.yxj.po.User;


public interface UserServer {
	public void addUser(User user);
	public User findUserByUsername (String username );
	public User findUserByUsernameInRedis (String username);
	public int getNum();

}
