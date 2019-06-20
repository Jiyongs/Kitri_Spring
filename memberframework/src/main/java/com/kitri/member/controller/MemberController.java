package com.kitri.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberService;

// 1) 컨트롤러임을 명시 - > 2) beans 생성해야하지만, servlet-context.xml에서 <context:component-scan base-package="com.kitri.member" /> 로 자동 스캔되므로 생성 필요 없음!
@Controller
@RequestMapping("/user")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 3) 객체 자동 매핑 설정
	//@Qualifier("Impl1"); // #MemberService 인터페이스를 implements하는 클래스가 여러 개 일때 지정해야 함!
	@Autowired
	private MemberService memberService;
	
	// #단순 페이지 이동 시, view 이름만 return하도록 returnType을 String으로 설정!
	// 1 가입 페이지로 이동
	@RequestMapping(value = "/register.kitri", method = RequestMethod.GET)      	// *GET 방식일 때 호출
	public String register() {
		return "user/member/member";			// = views폴더 밑의 경로 + member.jsp
	}
	
	// 2 가입 이벤트
	@RequestMapping(value = "/register.kitri", method = RequestMethod.POST)			// *POST 방식일 때 호출
	public String register(MemberDetailDto memberDetailDto, Model model) {			// 폼의 값을 dto에 담아 전해줌 / 조건 : form의 속성 이름 = dto 프로퍼티 이름
		int cnt = memberService.registerMember(memberDetailDto);
		if(cnt != 0) {
			model.addAttribute("userInfo", memberDetailDto);
			return "user/member/registerok";
		}
		return "user/member/registerfail";			// = views폴더 밑의 경로 + member.jsp
	}
	
	// 3 id 중복여부 체크
	@RequestMapping(value = "/idcheck.kitri", method = RequestMethod.GET)
	// # @ResponseBody : 이 메소드의 return되는 값이 경로가 아닌, 응답값임을 명시함.
	public @ResponseBody String idCheck(@RequestParam(name = "checkid", defaultValue = "") String id) { // #"checkid"라는 파라미터명으로 온 것과 매칭시킴 / 파라미터가 없을 경우 기본값은 ""로 지정
		logger.info("검색 id : " + id);
		String json = memberService.idCheck(id);
		return json;
	}

	// 4 우편번호 검색
	@RequestMapping("/zipsearch.kitri")
	@ResponseBody
	public String zipSearch(@RequestParam("doro") String doro) {
		logger.info("도로명 : " + doro);
		String json = memberService.zipSearch(doro);
		return json;
	}
	
	// 5 로그인 페이지로 이동
	@RequestMapping("/login.kitri")
	public String login() {
		return "user/login/login";				// = views폴더 밑의 경로 + login.jsp
	}
	
}
