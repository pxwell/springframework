package cn.pxwell.ioc.learn.importDemo;

import cn.pxwell.ioc.learn.entity.User;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{User.class.getName()};
	}
}
