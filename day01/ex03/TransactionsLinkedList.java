
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
		Integer deletionCount;

		deletionCount = 0;
		tmp = this.listStart;
		while (tmp != null)
		{
			if (tmp.getData().getIdentifier().compareTo(uuid) == 0)
			{
				if (tmp.equals(this.listStart))
					this.listStart = tmp.getNext();
				if (tmp.equals(this.listEnd))
					this.listEnd = tmp.getPrevious();
				if (tmp.getPrevious() != null)
					tmp.getPrevious().setNext(tmp.getNext());
				if (tmp.getNext() != null)
					tmp.getNext().setPrevious(tmp.getPrevious());
				size--;
				deletionCount++;
			}
			tmp = tmp.getNext();
		}
		if (deletionCount == 0)
			throw new TransactionNotFoundException("transaction with given id is not found");
	}

	static int test = 0;
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
			transactionArray[i] = tmp.getData();
			tmp = tmp.getNext();
			i++;
		}
		test++;
		return transactionArray;
	}
}
