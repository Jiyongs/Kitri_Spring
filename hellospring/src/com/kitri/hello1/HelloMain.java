package com.kitri.hello1;

public class HelloMain {

	public static void main(String[] args) {
		HelloServiceKor helloServiceKor = new HelloServiceKor();
		String msg = helloServiceKor.helloKor("홍길동");
		
		System.out.println(msg);
	}
	
}
