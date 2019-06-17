package com.kitri.hello4;

public class HelloServiceKor implements HelloService {

	// [생성자]
	public HelloServiceKor() {
		System.out.println("HelloSeviceKor 생성자 호출!");
	}
	
	public String hello(String name) {
		return name + "님 안녕하세요!!";
	}
	
}
