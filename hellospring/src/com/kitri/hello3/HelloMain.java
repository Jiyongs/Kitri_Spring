package com.kitri.hello3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.hello4.HelloServiceFactory;

public class HelloMain {

	public static void main(String[] args) {
		
		// HelloService helloService = new HelloServiceKor();
		// HelloService helloService = new HelloServiceEng(); //spring에서의 객체 = bean
		
		// 방법 1 (2.x)
		// 스프링의 Context에 접근
//		Resource resource = new ClassPathResource("com/kitri/hello3/applicationContext.xml") ;
//		BeanFactory factory = new XmlBeanFacto(resource);
//		HelloService helloService = factory.getBean("hs");
		
		System.out.println("1 프로그램 시작!");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/hello3/applicationContext.xml");
		System.out.println("2 설정 파일 읽었다!");

		HelloService helloService = context.getBean("hs", HelloService.class); // 인자2 타입으로 인자1을 얻어올거야
		System.out.println("3 서비스 얻어왔다!");
		
		String msg = helloService.hello("홍길동");
	
		System.out.println(msg);
	}
}
