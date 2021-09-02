package com.jj.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.jj.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ":Doing my DB Work Adding an Account");
	}
	
	public boolean doSilly() {
		System.out.println(getClass() + ":Doing my DB Work silly work in account");
		return false;
	}
	
}
