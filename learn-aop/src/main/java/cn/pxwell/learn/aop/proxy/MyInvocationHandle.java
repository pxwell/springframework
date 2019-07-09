package cn.pxwell.learn.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandle implements InvocationHandler {

	private Object obj;

	public MyInvocationHandle(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("==jdkProxy==");

		return method.invoke(obj,args);
	}
}
