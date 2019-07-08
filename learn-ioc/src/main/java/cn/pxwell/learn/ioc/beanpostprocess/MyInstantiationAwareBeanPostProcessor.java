package cn.pxwell.learn.ioc.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

/*@Component*/
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


	/**
	 * @see  org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition)
	 * @param beanClass the class of the bean to be instantiated
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 * 在实例化先 直接实例化对象， 不在继续后边的流程
	 */
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


	/**
	 * @See org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation(java.lang.Object, java.lang.String)
	 * @param bean the bean instance created, with properties not having been set yet
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 * 是否填充属性
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

		return true;
	}
}
