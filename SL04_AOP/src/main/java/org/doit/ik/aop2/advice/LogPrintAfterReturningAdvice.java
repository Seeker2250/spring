package org.doit.ik.aop2.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

// 실행 후 호출되는 공통 기능(예외없이)
@Component
public class LogPrintAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(
			Object returnValue, //결과값(return)
			Method method, 		// add()
			Object[] args,		//3, 5
			Object targe 		// 핵심 기능 실제 객체
			) throws Throwable {
		
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info("@@@"+methodName+ "() : logPrintAfterReturningAdvice 호출했당" + "~!~!~!");
		
	}
	
}
