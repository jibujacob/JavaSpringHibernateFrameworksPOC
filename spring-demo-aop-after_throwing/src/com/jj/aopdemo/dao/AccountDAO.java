package com.jj.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jj.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ":Doing my DB Work Adding an Account");
	}
	
	public boolean doSilly() {
		System.out.println(getClass() + ":Doing my DB Work silly work in account");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+" in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire) {
			throw new RuntimeException("No soup for you!!!");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		
		myAccounts.add(new Account("Jon","Silver"));
		myAccounts.add(new Account("Arya","Gold"));
		myAccounts.add(new Account("Sansa","Platinum"));
		
		return myAccounts;
	}
}
