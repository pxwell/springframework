package cn.pxwell.learn.ioc.service;

public class UserService {

	public UserService(){
		System.out.println( "========UserService()========" );
	}

	public UserService(MyService myService){
		//System.out.println( myService );
		System.out.println( "========UserService(MyService myService)========" );
	}
}
