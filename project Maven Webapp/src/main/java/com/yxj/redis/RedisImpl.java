package com.yxj.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yxj.dao.UserRedis;
import com.yxj.po.User;

@Service("redisImpl")
public class RedisImpl implements Redis {
	
	@Autowired
	@Qualifier("userRedisImpl")
	private UserRedis userRedisImpl;
	
	@Override
	public User getAttribute(String name) {
		User user=userRedisImpl.findUserByUsername(name);
		return user;
	}

	@Override
	public void setAttribute( User user) {
		userRedisImpl.addUser(user);
		
	}

	@Override
	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		
	}

}
