package cn.pxwell.lean.aop.service;

import org.springframework.stereotype.Component;

@Component
public class MyFirstAopService {


	public void print(){
		System.out.println( "=======原始的方法print()=========" );
	}

}
