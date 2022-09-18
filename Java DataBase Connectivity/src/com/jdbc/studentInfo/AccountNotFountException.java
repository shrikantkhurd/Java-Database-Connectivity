package com.jdbc.studentInfo;

public class AccountNotFountException extends Exception 
{ 
	AccountNotFountException()
	{
		super("Account not exist.");
	}
    public AccountNotFountException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 
