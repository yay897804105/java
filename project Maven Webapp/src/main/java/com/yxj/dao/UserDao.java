package com.yxj.dao;

import java.util.List;

import com.yxj.po.User;

public interface UserDao {
	
	public User findUserByUsername (String username);
	
	public void addtUser (User user);

	public User findUserById (int id);
	
	public List<User> findAll();
}
