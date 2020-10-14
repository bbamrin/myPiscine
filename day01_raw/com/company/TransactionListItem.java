package com.company;

public class TransactionListItem {
	private TransactionListItem next;
	private TransactionListItem previous;
	private Transaction data;

	public TransactionListItem getPrevious() {
		return previous;
	}

	public void setPrevious(TransactionListItem previous) {
		this.previous = previous;
	}

	public TransactionListItem getNext() {
		return this.next;
	}

	public void setNext(TransactionListItem next) {
		this.next = next;
	}

	public Transaction getData() {
		return this.data;
	}

	public TransactionListItem(Transaction transaction)
	{
		this.next = null;
		this.previous = null;
		this.data = transaction;
	}
}
