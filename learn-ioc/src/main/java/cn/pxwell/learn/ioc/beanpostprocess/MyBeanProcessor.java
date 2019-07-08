package cn.pxwell.learn.ioc.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/*@Component*/
public class MyBeanProcessor  implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println( "==="+beanName+"====MyBeanProcessor.postProcessBeforeInitialization========" );
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(  "==="+beanName+"====MyBeanProcessor.postProcessAfterInitialization========" );
		return bean;
	}
}
