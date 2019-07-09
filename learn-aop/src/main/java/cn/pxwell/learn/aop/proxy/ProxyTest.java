package cn.pxwell.learn.aop.proxy;

import cn.pxwell.learn.aop.entity.People;
import cn.pxwell.learn.aop.entity.Pxwell;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		/*byte[] b = ProxyGenerator.generateProxyClass( "$MyprovyTest",new Class[]{Pxwell.class} );

		try {
			FileOutputStream outputStream = new FileOutputStream( "$MyprovyTest.class" );

			outputStream.write( b );

			outputStream.flush();

			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

     People people = (People) Proxy.newProxyInstance( ProxyTest.class.getClassLoader(),
			 new Class[]{People.class},
			 new MyInvocationHandle( new Pxwell() ) );

     people.eat();

	}
}
