package com.company;

public class User {
	private Integer identifier;
	private String  name;
	private Integer balance;

	public User(Integer identifier, String name, Integer balance)
	{
		this.identifier = identifier;
		this.setBalance(balance);
		this.name = name;
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		if (balance >= 0)
			this.balance = balance;
	}
}
