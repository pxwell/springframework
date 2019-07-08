package cn.pxwell.learn.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class Showen implements BeanFactoryAware , InitializingBean {
	private  BeanFactory beanFactory;
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println( beanFactory );
		this.beanFactory  = beanFactory;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
			System.out.println( "=====InitializingBean======" );
	}


	public void init(){
		System.out.println( "=====xml init() =======" );
	}


	@PostConstruct
	public void init2(){
		System.out.println( "=====@PostConstruct =======" );
	}
}
