import java.util.Scanner;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        TransactionsList transactionsList;
        Integer transactionCount;
        Transaction someTransaction;
        Transaction[] transactionArray;
        Integer i;

        transactionCount = 12;
        i = -1;
        transactionsList = new TransactionsLinkedList();
        while (++i < transactionCount)
        {
            transactionsList.addTransaction(
                    new Transaction(
                            i % 2 == 0 ? Transaction.TransferCategory.DEBIT : Transaction.TransferCategory.CREDIT,
                            new User("sender " + Integer.toString(i), i * 100),
                            new User("recipient " + Integer.toString(i), i*1000),
                            UUID.randomUUID(),
                            i%2 == 0 ? i*250 : -1*i*250
                    ));
        }
        i = -1;
        transactionArray = transactionsList.toArray();
        while (++i < transactionArray.length)
        {
            System.out.printf(
                    "\nTransaction info\n Transaction sender: %s\n Transaction id: %s\n",
                    transactionArray[i].getSender().getName(),
                    transactionArray[i].getIdentifier().toString()
            );
        }
        someTransaction = transactionArray[2];
        transactionsList.removeTransaction(transactionArray[2].getIdentifier());
        transactionsList.removeTransaction(transactionArray[0].getIdentifier());
        transactionsList.removeTransaction(transactionArray[1].getIdentifier());
        transactionsList.removeTransaction(transactionArray[11].getIdentifier());
        transactionArray = transactionsList.toArray();
        i = -1;
        while (++i < transactionArray.length)
        {
            System.out.printf(
                    "\nTransaction info\n Transaction sender: %s\n Transaction id: %s\n",
                    transactionArray[i].getSender().getName(),
                    transactionArray[i].getIdentifier().toString()
            );
        }
        transactionsList.removeTransaction(someTransaction.getIdentifier());
    }
}
