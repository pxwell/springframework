package cn.pxwell.learn.ioc.importDemo;

import cn.pxwell.learn.ioc.entity.User;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{User.class.getName()};
	}
}
