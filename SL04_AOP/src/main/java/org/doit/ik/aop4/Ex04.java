package org.doit.ik.aop4;

import org.doit.ik.aop.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex04 {
	public static void main(String[] args) {
		//p226 annotation 기반 aspect
		//spring aop 모듈 우린 이미 있어 5.0.7이니깐!
		
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:org/doit/ik/aop4/application-context4.xml");
		
		//Calculator calc = ctx.getBean("calcProxy", Calculator.class);
		Calculator calc = ctx.getBean("calc4", Calculator.class);//이러면 proxy없어서 핵심 기능만 실행
		System.out.println(calc.add(3, 5));
		System.out.println("END");
		
	}//main
}//class
