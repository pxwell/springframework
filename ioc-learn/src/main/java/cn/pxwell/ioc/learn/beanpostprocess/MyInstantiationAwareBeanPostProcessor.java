package cn.pxwell.ioc.learn.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

/*@Component*/
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

		System.out.println( "说明： "+beanName +"调用  postProcessBeforeInstantiation " );
		if (beanClass == FoxProxy.class){
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass( beanClass );
			enhancer.setCallback(new MyMethodInterceptor()  );
			FoxProxy foxProxy = (FoxProxy) enhancer.create();

			System.out.println( "说明： "+beanName +"创建CGLIB代理对象成功！ " );
			return foxProxy;
		}

		return  null;
	}
}
