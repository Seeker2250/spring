package org.doit.ik.aop2;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {
	public static void main(String[] args) {
		//p206 Spring AOP
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:org/doit/ik/aop2/application-context2.xml");
		
		Calculator calc = ctx.getBean("calcProxy", Calculator.class);
//		Calculator calc = ctx.getBean("calc", Calculator.class);//이러면 proxy없어서 핵심 기능만 실행
		System.out.println(calc.add(3, 5));
		System.out.println("END");
		
	}//main
}//class
