package com.yxj.dao;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import com.yxj.po.User;
@Repository("userRedisImpl")
public class UserRedisImpl implements UserRedis {
	
	@Autowired
	private RedisTemplate redisTemplate;
	

	@Override
	public User findUserByUsername (String username) {
		ValueOperations<String, User> valueOperation=redisTemplate.opsForValue();
		User user=valueOperation.get(username);
		return user;
	}

	@Override
	public void addUser(User user) {
		ValueOperations<String, User> valueOperation=redisTemplate.opsForValue();
		valueOperation.set(user.getUsername(), user, 60, TimeUnit.HOURS);
		
	}

}
