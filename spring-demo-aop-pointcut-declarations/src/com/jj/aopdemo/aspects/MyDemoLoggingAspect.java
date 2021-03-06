package com.jj.aopdemo.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	//@Before("execution(public void add*())")
	//@Before("execution(* com.jj.aopdemo.dao.*.*(..))")
	@Before("com.jj.aopdemo.aspects.AopAspectExpressions.functionalfunctionsnogetternosetter()")
	public void beforeAddAccoubtAdvice(JoinPoint theJoinPoint ) {
		
		System.out.println("\n=====>>> Executing @Before advice on method ");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSig);
		
		System.out.println("Parameters: "+methodSig.getParameterNames());
		
	}
	
	@AfterReturning(
			pointcut="execution(* com.jj.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterRetunrningfindAccount(JoinPoint theJoinPoint,List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method :"+method);
		
		System.out.println("\n======>>> Executing @AfterReturning on result :"+result);
		
		convertAccountNameToUpperCase(result);
		
	}

	private void convertAccountNameToUpperCase(List<Account> result) {
		for(Account theaccount:result) {
			theaccount.setName(theaccount.getName().toUpperCase());
		}
	}
	

}
