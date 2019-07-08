import cn.pxwell.lean.aop.AppConfig;
import cn.pxwell.lean.aop.service.MyFirstAopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AopTest{

	@Test
	public void test1(){
		ApplicationContext context =new  AnnotationConfigApplicationContext( AppConfig.class );
		MyFirstAopService  myFirstAopService = (MyFirstAopService) context.getBean( "myFirstAopService" );
		myFirstAopService.print();
	}
}
