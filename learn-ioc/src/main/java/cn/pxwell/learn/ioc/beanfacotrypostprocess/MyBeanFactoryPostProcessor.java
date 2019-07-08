package cn.pxwell.learn.ioc.beanfacotrypostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;


@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;

		GenericBeanDefinition definition = (GenericBeanDefinition) factory.getBeanDefinition( "fox" );



		 definition.setAutowireMode( 3 );
	}
}
