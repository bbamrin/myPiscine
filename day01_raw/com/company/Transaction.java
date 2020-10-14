package com.company;

import java.util.UUID;

public class Transaction {
	enum TransferCategory{
		DEBIT,
		CREDIT
	}

	UUID identifier;
	User recipient;
	User sender;



	Integer transferAmount;

	public TransferCategory getCategory() {
		return category;
	}

	TransferCategory category;

	public Transaction(TransferCategory category, User sender, User recipient, UUID identifier, Integer transferAmount)
	{
		this.recipient = recipient;
		this.sender = sender;
		this.category = category;
		this.setTransferAmount(transferAmount);
	}

	public Integer getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(Integer transferAmount) {
		if (this.category == TransferCategory.CREDIT && transferAmount < 0)
			this.transferAmount = transferAmount;
		else if (this.category == TransferCategory.CREDIT && transferAmount > 0)
			this.transferAmount = transferAmount;
		else
			this.transferAmount = null;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public UUID getIdentifier() {
		return identifier;
	}

	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
}
