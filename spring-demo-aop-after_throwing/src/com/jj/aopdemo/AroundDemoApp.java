package com.jj.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jj.aopdemo.service.FortuneService;

public class AroundDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		FortuneService fortuneService = context.getBean("fortuneService",FortuneService.class);
		
		myLogger.info("Calling get fortune from main program");
		boolean tripWire =true;
		myLogger.info(fortuneService.getFortune(tripWire));
		
		context.close();
		
	}

};
