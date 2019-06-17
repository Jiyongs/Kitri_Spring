package com.kitri.hello4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kitri.hello4.HelloService;

public class HelloMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceFactory.class);
		HelloService helloService = context.getBean("hs", HelloService.class);
		String msg = helloService.hello("홍길동");
	
		System.out.println(msg);
	}
}
