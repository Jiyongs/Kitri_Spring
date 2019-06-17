package com.kitri.hello4;

public class HelloServiceEng implements HelloService {
	
	// [생성자]
	public HelloServiceEng() {
		System.out.println("HelloSeviceEng 생성자 호출!");
	}
	
	public String hello(String name) {
		return "Hello " + name;
	}
	
}
