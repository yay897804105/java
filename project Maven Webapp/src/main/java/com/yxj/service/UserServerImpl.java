package com.yxj.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.yxj.dao.UserDao;
import com.yxj.dao.UserDaoImpl;
import com.yxj.dao.UserRedis;
import com.yxj.dao.UserRedisImpl;
import com.yxj.po.User;

@Service("userServerImpl")
public class UserServerImpl implements UserServer{

	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDaoImpl;
	
	@Autowired
	@Qualifier("userRedisImpl")
	private UserRedis userRedisImpl;

	@Override
	public void addUser (User user ) {
		userDaoImpl.addtUser(user);
	}

	@Override
	public User findUserByUsername (String username) {
		User user=userDaoImpl.findUserByUsername(username);
		return user;
	}

	@Override
	public User findUserByUsernameInRedis(String username) {
		User user = userRedisImpl.findUserByUsername(username);
		return user;
	}

	@Override
	public int getNum() {
		List<User> u = userDaoImpl.findAll();
		int size=u.size();
		User user = u.get(size-1);
		int num = user.getId();
		return num+1;
	}

}
