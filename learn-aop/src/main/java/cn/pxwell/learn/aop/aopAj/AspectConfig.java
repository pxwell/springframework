package cn.pxwell.learn.aop.aopAj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {


	//@Pointcut("execution(* cn.pxwell.lean.aop.service.*.*(..))")
	@Pointcut("args(String)")
	private void pointcut() {

	}

	@Before("pointcut()"  )
	public void before(){
		System.out.println( "====before======" );
	}


	@After("pointcut()"  )
	public void after(){
		System.out.println( "====after======" );
	}


	@Around("pointcut()"  )
	public Object around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("around");
		Object[] args = point.getArgs();
		for(int i=0;i<args.length;i++){
			System.out.println("====args:"+args[i]);
			if(args[i].getClass().equals(String.class)){
				args[i] += "xxxx";
			}
		}
		Object result = point.proceed(args);

		return result;
	}
}
