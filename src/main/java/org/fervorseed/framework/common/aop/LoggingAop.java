package org.fervorseed.framework.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/**
* @package org.fervorseed.framework.aop
* @fileName LogginAop.java
* 
* @Company : FervorSeed
* @Author  : ike
* @Date    : 2015. 1. 24. 오후 5:14:37
* @Version : 1.0
* @Description : LogginAOP 설정
*/
@Component
@Aspect
public class LoggingAop {

	private static Logger logger = LoggerFactory.getLogger(LoggingAop.class);
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	/**
	 * 서비스 메서드 호출전 log 출력
	 * */
	@Before("execution(* org.fervorseed.framework.mapper..*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("logBefore is running!");
		logger.info("method : " + joinPoint.getSignature().getName());
		logger.info("******");
	}
	
	/**
	 * 서비스 메서드 결과 log 출력
	 * */
	@AfterReturning(
		pointcut = "execution(* org.fervorseed.framework.mapper..*.*(..)))",
		returning= "result"
	)
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		logger.info("logAfterReturning() is running!");
		logger.info("method : " + joinPoint.getSignature().getName());
		logger.info("Method returned value is : " + result);
		logger.info("******");
	}
	
	/**
	 * 서비스 메서드 
	 * */
	@AfterThrowing(
      pointcut = "execution(* org.fervorseed.framework.mapper..*.*(..)))",
      throwing= "error"
    )
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("method : " + joinPoint.getSignature().getName());
		logger.error("Exception : " + error.toString());
		logger.info("******");
    }
}
