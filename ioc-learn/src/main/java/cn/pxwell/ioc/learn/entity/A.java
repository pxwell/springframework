package cn.pxwell.ioc.learn.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*@Component*/
public class A {


    private 	String strA;
	@Autowired
	private B b;



	//循环依赖 失败 Requested bean is currently in creation: Is there an unresolvable circular reference
//	public A(B b){
//		System.out.println( "===A(B b)===" );
//		this.b = b;
//	}
}
