package cn.pxwell.learn.ioc.entity;

import org.springframework.beans.factory.annotation.Autowired;

/*@Component*/
public class B {

	private 	String strB;
	@Autowired
	private A a;


	//循环依赖 失败 Requested bean is currently in creation: Is there an unresolvable circular reference
	/*public B(A a){
		System.out.println( "===B(A a)===" );

		this.a = a ;
	}*/
}
