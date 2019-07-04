package cn.pxwell.ioc.learn.config;

import cn.pxwell.ioc.learn.service.MyService;
import cn.pxwell.ioc.learn.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
  将AppConfig2 转化为 AppConfig@EnhancerByCglib
 将AppConfig2 的beanDefinition的属性配置为full 类型。不配置为lite
 */

@Configuration
public class AppConfig2 {

	@Bean
	public MyService myService(){
		return  new MyService();
	}

	@Bean
	public UserService userService(){
		return  new UserService(myService());
	}
}
