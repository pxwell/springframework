package cn.pxwell.learn.aop.service;

import org.springframework.stereotype.Component;

@Component
public class MyFirstAopService {


	public void print(String  s){
		System.out.println( "=======原始的方法print(s)====s="+s+"====" );
	}

}
