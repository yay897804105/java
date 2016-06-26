package com.yxj.dao;

import com.yxj.po.User;

public interface UserRedis {
	public User findUserByUsername (String username);
	
	public void addUser (User user);

}
