package cn.pxwell.learn.aop.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/*@Component*/
public class AopMethodInterceptor  implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println( "======方法前调用=======" );
		Object o = invocation.proceed();
		System.out.println( "======方法后调用=======" );
		return o;
	}
}
