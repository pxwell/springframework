import cn.pxwell.learn.ioc.config.AppConfig;
import cn.pxwell.learn.ioc.entity.Fox;
import cn.pxwell.learn.ioc.entity.Monkey;
import org.junit.Test;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class IocTest {

	@Test
	public void test(){
		// AppConfig方式
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		 /*System.out.println( context.getBean( "fox" ));
		System.out.println( context.getBean( "fox1" ));
		System.out.println( context.getBean( "fox2" ));*/
	    DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();

		RootBeanDefinition beanDefinition = new RootBeanDefinition( Monkey.class );
 	    beanFactory.registerBeanDefinition( "monkey",beanDefinition );
		//beanDefinition.getPropertyValues().addPropertyValue( "name","张三年" );

		//1  byName  2 byType
		beanDefinition.setAutowireMode( 1 );


		System.out.println(((Monkey)context.getBean( "monkey" )).getFox());
	}

	@Test
	public void test1(){
		// AppConfig方式
		ApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );

	   Fox fox = (Fox) context.getBean( "fox" );
		System.out.println( fox.getName() );
	}


	@Test
	public void test2(){

		DefaultListableBeanFactory registry = new DefaultListableBeanFactory(  );

		//BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry(  );
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(  registry );
		reader.loadBeanDefinitions( "Spring.xml" );


		System.out.println( Arrays.toString(registry.getBeanDefinitionNames()) );


		System.out.println( registry.getBean("fox") );
	}
}
