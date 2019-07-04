package cn.pxwell.ioc.learn.service;

public class TestService {


	public TestService() {
		System.out.println( "=======TestService()======" );
	}


	public TestService(UserService userService) {
		//System.out.println( userService );
		System.out.println( "=======TestService(UserService userService)======" );
	}

}
