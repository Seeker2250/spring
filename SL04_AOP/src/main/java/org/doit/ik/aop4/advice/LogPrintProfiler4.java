package org.doit.ik.aop4.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//<aop:aspect id="traceAspect" ref="logPrintProfiler4"><!-- 보조객체 -->
@Aspect
@Component
public class LogPrintProfiler4 {
	
	//<aop:pointcut expression="execution(* org.doit.ik.aop..*.*(*,*))" id="samplePointcut"/>
	@Pointcut("execution(* org.doit.ik.aop..*.*(*,*))")
	private void samplePointcut() {}
	
	//3. after advice p223
	//<aop:after method="afterFinal" pointcut-ref="samplePointcut"/>
	@After("samplePointcut()")
	public void afterFinal(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
	      Log log = LogFactory.getLog(this.getClass());
	      log.info(">>> " + methodName + "() : LogPrintProfiler4.afterFinal 가 호출됨... ");
	}
	
	
	//2. before advice p219
	//<aop:before method="before" pointcut-ref="samplePointcut"/>
	@Before("samplePointcut()")
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
	      Log log = LogFactory.getLog(this.getClass());
	      log.info(">>> " + methodName + "() : LogPrintProfiler4.before 가 호출됨... ");
	}
	
	//pdf 224p
	//advice만 만들면 전처럼 class 하나하나 만들 필요가 없다는거야.
	
	// 1. around advice
	//<aop:around method="trace" pointcut-ref="samplePointcut"/>
	@Around("samplePointcut()")
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
