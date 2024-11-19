package org.doit.ik.aop3.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class LogPrintProfiler3 {
	
	//3. after advice p223
	public void afterFinal(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
	      Log log = LogFactory.getLog(this.getClass());
	      log.info(">>> " + methodName + "() : LogPrintProfiler4.afterFinal 가 호출됨... ");
	}
	
	
	//2. before advice p219
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
	      Log log = LogFactory.getLog(this.getClass());
	      log.info(">>> " + methodName + "() : LogPrintProfiler4.before 가 호출됨... ");
	}
	
	//pdf 224p
	//advice만 만들면 전처럼 class 하나하나 만들 필요가 없다는거야.
	
	// 1. around advice
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		  String methodName = joinPoint.getSignature().toShortString();

	      Log log =  LogFactory.getLog(this.getClass());
	      log.info("> " + methodName +"() start.");

	      StopWatch sw = new StopWatch();
	      sw.start();       

	      // 핵심 관심 사항.
	      Object  result = joinPoint.proceed() ;  // calc.add()     

	      sw.stop();

	      log.info("> " + methodName +"() end.");
	      log.info("> " + methodName +"() 처리 시간 :  " + sw.getTotalTimeMillis() +"ms");

	      return result;
	}
	// 2. before advice
	// 3. after~ advice
	
}
