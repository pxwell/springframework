package cn.pxwell.learn.ioc.entity;

import org.springframework.stereotype.Component;

@Component
public class Monkey {
	private String name;

   private 	Fox fox;

	public Monkey() {
		System.out.println( "==== Monkey()====" );
	}

	public Monkey(Fox fox) {
		System.out.println( "==== Monkey(Fox fox)====" );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Fox getFox() {
		return fox;
	}

	public void setFox(Fox fox) {
		System.out.println( "=======setFox(Fox fox)=======" );
		this.fox = fox;
	}
}
