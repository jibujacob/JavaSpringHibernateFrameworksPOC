package com.jj.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jj.aopdemo.dao.AccountDAO;

public class AfterDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);

		
		List<Account> myAccount = null;
		
		try {
			boolean tripWire=false;
			myAccount=accountDAO.findAccounts(tripWire);
		}catch(Exception e) {
			System.out.println("\n\nMain Program .. caught exception:"+ e);
		}
		
		System.out.println("\n\nMain Program:");
		
		System.out.println(myAccount);
		
		
		context.close();
		
	}

};
