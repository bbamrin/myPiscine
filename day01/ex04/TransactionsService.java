
import java.util.UUID;

public class TransactionsService {
	private UserList userList;

	public TransactionsService()
	{
		userList = new UsersArrayList();
	}

	public void addUser(String userName, Integer userBalance)
	{
		User user = new User(userName, userBalance);
		this.userList.addUser(user);
	}

	public void addUser(User user)
	{
		this.userList.addUser(user);
	}

	public void performTransfer(Integer recipientId, Integer senderId, Integer transferAmount)
	{
		UUID id;
		Transaction credit;
		Transaction debit;

		id = UUID.randomUUID();
		if (transferAmount > userList.getUserById(senderId).getBalance())
			throw new IllegalTransactionException("transfer amount is higher than sender balance");
		credit = new Transaction(
				Transaction.TransferCategory.CREDIT,
				this.userList.getUserById(senderId),
				this.userList.getUserById(recipientId),
				id,
				-1 * transferAmount
				);
		debit = new Transaction(
				Transaction.TransferCategory.DEBIT,
				this.userList.getUserById(senderId),
				this.userList.getUserById(recipientId),
				id,
				transferAmount
		);
		credit.setPair(debit);
		debit.setPair(credit);
		userList.getUserById(recipientId).getTransactionsList().addTransaction(debit);
		userList.getUserById(senderId).getTransactionsList().addTransaction(credit);
	}

	public Integer retrieveUserBalance(Integer userId)
	{
		return this.userList.getUserById(userId).getBalance();
	}

	public Transaction[] retrieveTransfers(Integer userId)
	{
		return this.userList.getUserById(userId).getTransactionsList().toArray();
	}

	public Transaction[] checkValidity(Integer userId)
	{
		TransactionsLinkedList unpairedTransactions;

		unpairedTransactions = new TransactionsLinkedList();
		for (int i = 0; i < this.userList.getUserNumber(); ++i)
		{
			Transaction[] tmpTransactionArray = this.userList.getUserByIndex(i).getTransactionsList().toArray();
			for (int j = 0; j < tmpTransactionArray.length; ++j)
				if (tmpTransactionArray[i].getPair() == null)
					unpairedTransactions.addTransaction(tmpTransactionArray[i]);
		}
		return unpairedTransactions.toArray();
	}

	public void removeTransactionById(UUID transactionId, Integer userId)
	{
		this.userList.getUserById(userId).getTransactionsList().removeTransaction(transactionId);
	}
}
