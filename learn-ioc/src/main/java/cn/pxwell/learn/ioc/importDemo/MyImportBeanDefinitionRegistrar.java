package cn.pxwell.learn.ioc.importDemo;

import cn.pxwell.learn.ioc.entity.Fox;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

		RootBeanDefinition beanDefinition = new RootBeanDefinition( Fox.class );
		registry.registerBeanDefinition( "fox",beanDefinition );
	}
}
