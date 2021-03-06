package com.jj.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	private static Logger myLogger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	@Pointcut("execution(* com.jj.springdemo.controller.*.*(..))")
	public void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.jj.springdemo.service.*.*(..))")
	public void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.jj.springdemo.dao.*.*(..))")
	public void forDAOPackage() {
		
	}
	
	@Pointcut("forControllerPackage()|| forServicePackage()||forDAOPackage()")
	public void appFlow() {
		
	}
	
	@Before("appFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String mymethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====> Executing @Before: calling the method: "+ mymethod);
		
		Object myparam[]= theJoinPoint.getArgs();
		
		for(Object param : myparam) {
			myLogger.info("\n====> Executing @Before: calling the parameter: "+ param);
		}
		
	}
	
	@AfterReturning(
			pointcut="appFlow()",
			returning="result")
	public void after(JoinPoint theJoinPoint,Object result) {
		
		String mymethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====> Executing @After: calling the method: "+ mymethod);
		
		Object myparam[]= theJoinPoint.getArgs();
		
		myLogger.info("\n===> Result: "+ result);
		
		
		
	}
	
	

}
