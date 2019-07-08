package cn.pxwell.learn.ioc.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//xml
@Component
public class Fox {
	@Value("${name}" )
	private String name;




	public Fox() {
		System.out.println( "------public Fox() -------" );
	}



	@Autowired
	public Fox(Monkey monkey,@Value(  "${name}" )String name) {
		System.out.println( "------Fox(Monkey monkey,String name) ----- name = "+name+"--------" );
	}



	public Fox(Monkey monkey,Tiger tiger) {
		System.out.println( "------Fox(Monkey monkey,Tiger tiger) ----" );
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
