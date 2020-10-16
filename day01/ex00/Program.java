
import java.util.Scanner;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        User sender;
        User recipient;
        Transaction transaction;

        sender = new User(123, "testUser1", 35000);
        System.out.printf("sender info\n  id: %s\n  name: %s\n  balance: %s\n\n",
                sender.getIdentifier(),
                sender.getName(),
                sender.getBalance()
        );
        recipient = new User(321, "testUser2", 1000000);
        System.out.printf("recipient info\n  id: %s\n  name: %s\n  balance: %s\n\n",
                recipient.getIdentifier(),
                recipient.getName(),
                recipient.getBalance()
        );
        transaction = new Transaction(Transaction.TransferCategory.DEBIT, sender, recipient, UUID.randomUUID(), 500000);
        System.out.printf("transaction info\n  category: %s\n  sender: %s\n  recipient: %s\n  id: %s\n  transfer amount: %s\n",
                transaction.getCategory().toString(),
                transaction.getSender().getName(),
                transaction.getRecipient().getName(),
                transaction.getIdentifier(),
                transaction.getTransferAmount()
        );
    }
}
