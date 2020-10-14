package com.company;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{

	private TransactionListItem listStart;
	private TransactionListItem listEnd;
	private TransactionListItem next;
	private Integer size;

	public TransactionsLinkedList()
	{
		size = 0;
		this.listStart = null;
		this.listEnd = null;
		this.next = null;
	}

	@Override
	public void addTransaction(Transaction transaction) {
		if (listStart == null)
		{
			listStart = new TransactionListItem(transaction);
			listEnd = listStart;
		}
		else
		{
			listEnd.setNext(new TransactionListItem(transaction));
			listEnd.getNext().setPrevious(listEnd);
			listEnd = listEnd.getNext();
		}
		size++;
	}

	@Override
	public void removeTransaction(UUID uuid) {
		TransactionListItem tmp;

		tmp = this.listStart;
		while (tmp != null)
		{
			if (tmp.getData().getIdentifier().compareTo(uuid) == 0)
			{
				if (tmp.getPrevious() != null)
					tmp.getPrevious().setNext(tmp.getNext());
				if (tmp.getNext() != null)
					tmp.getNext().setPrevious(tmp.getPrevious());
				size--;
			}
			tmp = tmp.getNext();
		}
		throw new TransactionNotFoundException("transaction with given id is not found");
	}

	@Override
	public Transaction[] toArray() {
		Transaction transactionArray[];
		TransactionListItem tmp;
		int i;

		tmp = listStart;
		i = 0;
		transactionArray = new Transaction[size];
		while (tmp != null)
		{
			transactionArray[i++] = tmp.getData();
			tmp = tmp.getNext();
		}
		return transactionArray;
	}
}
