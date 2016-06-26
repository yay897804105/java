package com.yxj.po;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value="Person")
@Document(collection="user")
public class User implements Serializable {
	
	@Id
	private int id;
	
	private String username;
	
	private String password;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@PersistenceConstructor
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(){
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
