package org.doit.ik.test;

import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {
	public static void main(String[] args) {
		//root-context.xml : Spring Bean 객체를 생성 + DI 설정파일
		//ApplicationContext = 공장 = Spring Container
		//XmlWeb[AppliacationContext] p59
		String resourceLocations ="classpath:org/doit/ik/di/application-context.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		RecordViewImpl rvi = ctx.getBean("rvi", RecordViewImpl.class);
		
		rvi.input();
		rvi.output();
		System.out.println("END");
	}//main
}//class
