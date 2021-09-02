package com.jj.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;


@Component
public class FortuneService {
	
	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "You Lucky!!!";
	}

	public String getFortune(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("Major traffic!!!!");
		}
		return null;
	}
	
}
