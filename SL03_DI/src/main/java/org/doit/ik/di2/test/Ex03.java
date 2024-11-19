package org.doit.ik.di2.test;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;
import org.doit.ik.di2.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


public class Ex03 {
	public static void main(String[] args) {
		//ApplicationContext 객체 AnnotationConfigApplicationContext로 (pdf 62)
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		//RecordViewImpl rvi = ctx.getBean("rvi", RecordViewImpl.class);
		RecordViewImpl rvi = ctx.getBean("getRecordViewImpl", RecordViewImpl.class);
		
		rvi.input();
		rvi.output();
		System.out.println("END");
		
	}//main

}//class
