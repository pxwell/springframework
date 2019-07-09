package cn.pxwell.learn.aop.entity;

public class Pxwell implements People {
	@Override
	public void eat() {
			System.out.println( "+===============+" );
	}

	@Override
	public Object work(Object o) {
		return null;
	}
}
