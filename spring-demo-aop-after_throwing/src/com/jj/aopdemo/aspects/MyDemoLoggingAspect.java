package com.jj.aopdemo.aspects;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jj.aopdemo.Account;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	@Around("execution(* com.jj.aopdemo.service.FortuneService.getFortune(..))")
	public Object aroungGetFortune(
			ProceedingJoinPoint theproceedingJoinPoint) throws Throwable{
		
		myLogger.info("\n=====>>> Executing @Around advice on method:"+theproceedingJoinPoint.getSignature().toShortString());
		
		long begin = System.currentTimeMillis();
		Object result=null;
		try {
			result = theproceedingJoinPoint.proceed();
		}catch(Exception e) {
			myLogger.warning(e.toString());
			result="Nothing happening here,please move on";
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end-begin;
		myLogger.info("\n=====>>> Duration: "+ duration/1000 + " seconds");
		
		return result;
	
	}
	//@Before("execution(public void add*())")
	//@Before("execution(* com.jj.aopdemo.dao.*.*(..))")
	@Before("com.jj.aopdemo.aspects.AopAspectExpressions.functionalfunctionsnogetternosetter()")
	public void beforeAddAccoubtAdvice(JoinPoint theJoinPoint ) {
		
		myLogger.info("\n=====>>> Executing @Before advice on method ");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+methodSig);
		
		myLogger.info("Parameters: "+methodSig.getParameterNames());
		
	}
	
	@After("execution(* com.jj.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccoubtAdvice(JoinPoint theJoinPoint ) {
		
		myLogger.info("\n=====>>> Executing @After(finally) advice on method ");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: "+methodSig);
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.jj.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterRetunrningfindAccount(JoinPoint theJoinPoint,List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterReturning on method :"+method);
		
		myLogger.info("\n======>>> Executing @AfterReturning on result :"+result);
		
		convertAccountNameToUpperCase(result);
		
	}

	private void convertAccountNameToUpperCase(List<Account> result) {
		for(Account theaccount:result) {
			theaccount.setName(theaccount.getName().toUpperCase());
		}
	}
	
	@AfterThrowing(
		pointcut="execution(* com.jj.aopdemo.dao.AccountDAO.findAccounts(..))",
		throwing="excep")
	public void afterThrowingFindAccount(JoinPoint theJoinPoint,Throwable excep) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n======>>> Executing @AfterThrowing on method :"+method);
		
		myLogger.info("\n======>>> Executing @AfterThrowing on result :"+excep);
		
	}
	

}
