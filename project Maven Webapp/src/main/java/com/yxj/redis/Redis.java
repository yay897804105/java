package com.yxj.redis;

import com.yxj.po.User;

public interface Redis {
	
	public User getAttribute (String name);
	
	public void setAttribute (User user);
	
	public void removeAttribute (String name);

}
