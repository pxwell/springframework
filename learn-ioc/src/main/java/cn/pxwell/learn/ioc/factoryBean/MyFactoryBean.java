package cn.pxwell.learn.ioc.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/*@Component*/
public class MyFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		return new ReentrantLock(  );
	}

	@Override
	public Class<?> getObjectType() {
		return ReentrantLock.class;
	}
}
