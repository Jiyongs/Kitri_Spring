package com.kitri.member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberService;

import sun.nio.cs.ext.MacCyrillic;

// 1) 컨트롤러임을 명시 - > 2) beans 생성해야하지만, servlet-context.xml에서 <context:component-scan base-package="com.kitri.member" /> 로 자동 스캔되므로 생성 필요 없음!
@Controller
@RequestMapping("/user")
//@SessionAttributes(names = {"userInfo", "b", "c"}) // 세션 여러 개인 경우 
@SessionAttributes("userInfo") 	  // 세션 1개인 경우 | "userInfo"라는 이름의 Attribute는 모두 session에 담기게 설정함 | session은 30분동안 계속 유지되는 정보
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 3) 객체 자동 매핑 설정
	//@Qualifier("Impl1"); // # MemberService 인터페이스를 implements하는 클래스가 여러 개 일때 지정해야 함!
	@Autowired
	private MemberService memberService;
	
	// # 단순 페이지 이동 시, view 이름만 return하도록 returnType을 String으로 설정!
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
			model.addAttribute("registerInfo", memberDetailDto);
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
	@RequestMapping(value= "/login.kitri", method = RequestMethod.GET)
	public String login() {
		return "user/login/login";				// = views폴더 밑의 경로 + login.jsp
	}
	
	// 6 로그인 (spring 다운 방법은 x)
//	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
//	public String login(@RequestParam("id") String id,@RequestParam("pass") String pass, HttpSession session) {
//		MemberDto memberDto = memberService.loginMember(id, pass);
//		if(memberDto != null) {
//			session.setAttribute("userInfo", memberDto);
//			return "user/login/loginok";
//		} else {
//			return "user/login/loginfail";
//		}
//	}
	
	// 6 로그인
	// # servlet api(session 등)은 왠만하면 쓰지 않기 => Model을 사용하여, addAttribute()하기!
	@RequestMapping(value = "/login.kitri", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model) { //# Model은 request와 같음. Model에 넣은 값은 다음 페이지에서만 사용 가능

		MemberDto memberDto = memberService.loginMember(map);
		if(memberDto != null) {
			model.addAttribute("userInfo", memberDto); // # 클래스 위에 @SessionAttributes("userInfo") 지정 필요
			return "user/login/loginok";
		} else {
			return "user/login/loginfail";
		}
	}
	
	// 7 로그아웃 (spring 다운 방법은 x)
//	@RequestMapping("/logout.kitri")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userInfo");
//		return "redirect:/index.jsp"; //# redirect로 보내기
//	}
	
	// # SessionStatus sessionStatus : Model과 @SessionAttributes("userInfo")로 설정한 세션 얻어오기
	// # @ModelAttribute("userInfo") : Model에 설정된 "userInfo"라는 이름의 세션에 있는 값을 인자값에 얻어오겠다
	@RequestMapping("/logout.kitri")
	public String logout(@ModelAttribute("userInfo") MemberDto memberDto, SessionStatus sessionStatus) {
			sessionStatus.setComplete();  // # Model과 @SessionAttributes("...")로 설정한 모든 세션을 지우기 위한 부분
			return "redirect:/index.jsp"; // # redirect로 보내기 // # forward로 보내려면, prefix를 지워야 함			
		
	}
	
	
	

}
