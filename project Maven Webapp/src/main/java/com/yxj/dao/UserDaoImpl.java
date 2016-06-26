package com.yxj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.yxj.po.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
	
	
	@Autowired
	private MongoTemplate mongoTemplate;
	


	@Override
	public User findUserByUsername(String username) {	
		
		Query query=new Query();
		query.addCriteria(new Criteria("username").is(username));
		return mongoTemplate.findOne(query, User.class);

	}

	@Override
	public void addtUser(User user) {
		mongoTemplate.insert(user);
		
	}

	@Override
	public User findUserById(int id) {
		Query query=new Query();
		query.addCriteria(new Criteria("id").is(id));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(User.class);
	}

}
