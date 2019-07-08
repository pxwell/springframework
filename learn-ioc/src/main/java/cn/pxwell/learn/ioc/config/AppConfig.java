package cn.pxwell.learn.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
  将AppConfig2 转化为 AppConfig@EnhancerByCglib
 将AppConfig2 的beanDefinition的属性配置为full 类型。不配置为lite
 */

@ComponentScan("cn.pxwell.ioc.learn")
@Configuration
@PropertySource("classpath:system.properties" )
public class AppConfig {

	/*@Bean
	public MyService myService(){
		return  new MyService();
	}*/

	/*@Bean
	public UserService userService(){
		return  new UserService(myService());
	}*/


	//测试 aware init 加载等
	/*@Bean(initMethod = "init")
	public Showen showen(){
		return  new Showen();
	}*/

	/*@Bean
	public TestBean testBean() {
		TestBean testBean = new TestBean();
		testBean.setName(env.getProperty("testbean.name"));
		return testBean;
	}*/


/*	@Value( "${name}" )
	String name;

	@Bean
	public String tname (){
		System.out.println( name );
		return name;
	}*/
}
