package cn.pxwell.lean.aop;

import cn.pxwell.lean.aop.interceptor.AopMethodInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.pxwell.lean.aop")
public class AppConfig {

	//BeanNameAutoProxyCreator (AOP)  粒度大 类级别的 代理
/*	@Bean
	public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
		BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
		proxyCreator.setBeanNames( "*Service" );
		proxyCreator.setInterceptorNames( "aopMethodInterceptor" );
		return proxyCreator;
	}*/


//***************************************************************************************************************
	@Bean
	public AopMethodInterceptor aopMethodInterceptor(){
			return new AopMethodInterceptor();
	}

	@Bean
   public 	NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor(){

	   NameMatchMethodPointcutAdvisor pointcutAdvisor = new NameMatchMethodPointcutAdvisor(  );
	   pointcutAdvisor.setMappedNames("print"  ); //方法级别的
	   pointcutAdvisor.setAdvice( aopMethodInterceptor() );
	   return pointcutAdvisor;
   }

   @Bean
   public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		return new DefaultAdvisorAutoProxyCreator();
   }


//***************************************************************************************************************




}
