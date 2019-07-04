package cn.pxwell.ioc.learn.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//xml
public class Fox {

	//@Autowired
	private User user;


	public Fox() {
		System.out.println( "------public Fox() -------" );
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public User getUser() {
		return user;
	}

	//xml  property 标签 注入属性
	public void setUser(User user) {
		System.out.println( "----setUser(User user)----" );
		this.user = user;
	}
}
