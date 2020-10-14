package com.company;

public class User {
	private Integer identifier;
	private String  name;
	private Integer balance;
	private TransactionsList transactionsList;

	public User(String name, Integer balance)
	{
		this.identifier = identifier;
		transactionsList = new TransactionsLinkedList();
		this.setBalance(balance);
		this.name = name;
		this.identifier = UserIdsGenerator.getInstance().generateId();
	}

	public Integer getIdentifier() {
		return identifier;
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
