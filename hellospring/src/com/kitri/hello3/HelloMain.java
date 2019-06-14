package com.kitri.hello3;

import java.io.ObjectInputStream.GetField;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloMain {

	public static void main(String[] args) {
		// HelloService helloService = new HelloServiceKor();
		// HelloService helloService = new HelloServiceEng(); //spring에서의 객체 = bean
		
		// 방법 1 (2.x)
		// 스프링의 Context에 접근
//		Resource resource = new ClassPathResource("com/kitri/hello3/applicationContext.xml") ;
//		BeanFactory factory = new XmlBeanFacto(resource);
//		HelloService helloService = factory.getBean("hs");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/hello3/applicationContext.xml");
		HelloService helloService = context.getBean("hs", HelloService.class); // 인자2 타입으로 인자1을 얻어올거야
		String msg = helloService.hello("홍길동");
	
		System.out.println(msg);
	}
}
