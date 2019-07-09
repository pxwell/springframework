package cn.pxwell.learn.aop;

import cn.pxwell.learn.aop.interceptor.AopMethodInterceptor;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cn.pxwell.learn.aop")
//true 使用CGLib代理
@EnableAspectJAutoProxy(proxyTargetClass=true)
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
	/*@Bean
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
*/

//***************************************************************************************************************




}
