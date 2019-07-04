package com.kitri.hello3;

public class HelloServiceKor implements HelloService {

	// DI 방법 2가지
	
	private HelloDao helloDao;

	// 1) setter
	//  public void setHelloDao(HelloDao helloDao){
	// 		this.helloDao = helloDao;
	// }
	 
	// 2) 생성자
	public HelloServiceKor(HelloDao helloDao) {
		this.helloDao = helloDao;
	}


	// [생성자]
	/*
	 * public HelloServiceKor() { System.out.println("HelloSeviceKor 생성자 호출!"); }
	 */

	public String hello(String name) {
		return name + "님 안녕하세요!! \n" + helloDao.getGreeting();
	}

}
