package com.yxj.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.yxj.dao.UserRedis;
import com.yxj.po.User;

public class Test1 implements Filter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserRedis redis=(UserRedis) applicationContext.getBean("userRedisImpl");
//		User user=new User("aaa","bbb");
//		user.setId(5);
//		redis.addUser(user);
		User user=redis.findUserByUsername("aaa");
		System.out.print(user.getId());
		//UserDao userDao=(UserDao) applicationContext.getBean("userDaoImpl");
		//		userDao.insertUser(user);
		//		List<User> l=(List<User>) userDao.findUserByUsername("jack");
		//	    System.out.println(l.size());
		//	    User user2=l.get(0);
		//	    System.out.println(user2.getId());
		//		System.out.print(user2.getUsernam());
		//	    MongoMappingContext a=new MongoMappingContext();
		//userDao.addtUser(user);
		//		User user2=new User();
		//		user2=userDao.findUserById(8);
		//		System.out.print(user2.getUsernam());
		//		int a=1;
		//UserRedis redis=applicationContext.getBean(UserRedisImpl.class);
		//redis.addUser(user);
//		User user=new User("aaa","bbb");
//		userDao.addtUser(user);
//		User user2=userDao.findUserByUsername("aaa");
//		System.out.println(user2.getId());
//		if(user2==null) {
//			System.out.print("asdad");
//		} else {
//			Syst
//		}
//		if(user2!=null)
//		{
//			System.out.print(user2.getPassword());
//		} else {
//			System.out.print("kong");
//		}
//		InternalResourceViewResolver a=new InternalResourceViewResolver();

		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
