package com.kitri.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/kitri/ditest/applicationContext.xml");
		
		MemberDto m1 = context.getBean("m1", MemberDto.class);
		System.out.println("------------------------------ m1 -------------------------------");
		System.out.println(m1);
	
		MemberDto m2 = context.getBean("m2", MemberDto.class);
		System.out.println("------------------------------ m2 -------------------------------");
		System.out.println(m2);
		
		MemberDto m3 = context.getBean("m3", MemberDto.class);
		System.out.println("------------------------------ m3 -------------------------------");
		System.out.println(m3);

		MemberDto m4 = context.getBean("m4", MemberDto.class);
		System.out.println("------------------------------ m4 -------------------------------");
		System.out.println(m4);

		MemberDto m5 = context.getBean("m5", MemberDto.class);
		System.out.println("------------------------------ m5 -------------------------------");
		System.out.println(m5);

		MemberDto m6 = context.getBean("m6", MemberDto.class);
		System.out.println("------------------------------ m6 -------------------------------");
		System.out.println(m6);

		MemberDto m7 = context.getBean("m7", MemberDto.class);
		System.out.println("------------------------------ m7 -------------------------------");
		System.out.println(m7);

	}

}
