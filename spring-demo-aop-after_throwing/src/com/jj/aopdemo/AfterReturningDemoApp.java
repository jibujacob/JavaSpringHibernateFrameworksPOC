package com.jj.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jj.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

		
		List<Account> myAccount = accountDAO.findAccounts(false);
		
		System.out.println("\n\nMain Program:");
		System.out.println(myAccount);
		
		
		context.close();
		
	}

};
