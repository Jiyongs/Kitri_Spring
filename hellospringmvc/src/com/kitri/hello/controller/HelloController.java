package com.kitri.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.hello.model.service.HelloService;

import oracle.net.aso.h;

// 모든 클래스는 @Component 이고, 세부적으로 @Repository, @Controller 설정이 가능
@Controller										// 1) HelloController.java = Controller 역할의 클래스임을 알려줌!
public class HelloController {					// 2) Controller를 객체로 만들어야 함! (dispatcher-servlet.xml에서)

	private HelloService helloService;
	
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	@RequestMapping("/hello.kitri")				// 3) .kitri로 들어온 요청은 밑의 메소드로 처리함을 알려줌!
	public ModelAndView greeting() {
		ModelAndView mav = new ModelAndView();	// 4) ModelAndView 객체에 Attribute & path를 설정해줌
		String msg = helloService.hello("홍길동");
		mav.addObject("msg", msg);				// = setAttribute(Object)
		mav.setViewName("result");				// = view(=path) 이름
		return mav;
	}
	
}
