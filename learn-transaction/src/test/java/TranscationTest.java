import cn.pxwell.learn.transaction.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TranscationTest {

	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext( "spring-context.xml" );

		AccountService accountService = (AccountService) context.getBean( "accountServiceImpl" );

		accountService.createAccount( "雷部2",1030.0 );
	}
}
