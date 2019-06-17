package com.kitri.hello4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloServiceFactory {

	// HelloService 객체 리턴
	@Bean(name = {"hs", "helloservice"}) // 여러 개의 name 가질 수 있음
	@Scope(value="prototype")
	public HelloService getHelloService() {
		return new HelloServiceKor();
	}
	
}
