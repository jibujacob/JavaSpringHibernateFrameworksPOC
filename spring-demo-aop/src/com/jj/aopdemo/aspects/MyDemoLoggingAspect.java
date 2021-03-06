package com.jj.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.jj.aopdemo.dao.*.*(..))")
	public void forDAOPackages() {
		
	}
	
	//@Before("execution(public void add*())")
	//@Before("execution(* com.jj.aopdemo.dao.*.*(..))")
	@Before("forDAOPackages()")
	public void beforeAddAccoubtAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on method ");
	}
	
	@Before("forDAOPackages()")
	public void beforeAddAccoubtAdviceAnalytics() {
		System.out.println("\n=====>>> Executing @Before advice on methods for analytics");
	}

}
