package org.doit.ik.di2;

import org.doit.ik.di.RecordImpl;
import org.doit.ik.di.RecordViewImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application-context.xml == 자바 클래스 config 파일
// pdf 68

//pdf 87 자바 코드를 이용한 스프링 설정
@Configuration
public class Config {
	/* <bean id="record" class="org.doit.ik.di.RecordImpl"></bean> */
//	위와 아래는 완벽하게 일치하는 코딩
	@Bean
	public RecordImpl record() {// method 이름을 bean 객체의 식별자로 사용
		return new RecordImpl();
	}
	
	
	
	/*
	  <bean id="rvi" class="org.doit.ik.di.RecordViewImpl">
	  <property name="record">
	  <ref bean="record"/> </property>
	  </bean>
	 */
	
	
// 	  name 속성 건드려서 가져오자
	  @Bean//(name = "rvi")
	  public RecordViewImpl getRecordViewImpl() { 
		  RecordViewImpl rvi = new RecordViewImpl();
		  rvi.setRecord(record());
		  return rvi; }
	
}//class
