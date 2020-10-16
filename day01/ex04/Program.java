
import java.util.Scanner;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        TransactionsService transactionsService;
        User user1;
        User user2;

        transactionsService = new TransactionsService();
        user1 = new User("test1", 999);
        user2 = new User("test2", 1032);
        transactionsService.addUser(user1);
        transactionsService.addUser(user2);
        System.out.printf("Balance info:\n user1 balance: %d\n user2 balance: %d\n\n",
                transactionsService.retrieveUserBalance(user1.getIdentifier()),
                transactionsService.retrieveUserBalance(user2.getIdentifier())
        );
        transactionsService.performTransfer(
                user1.getIdentifier(),
                user2.getIdentifier(),
                100
                );
        System.out.printf(
                "Transaction info:\n transaction category: %s\n transaction amount: %d\n transaction category: %s\n transaction amount: %d\n",
                (user1.getTransactionsList().toArray())[0].getCategory(),
                (user1.getTransactionsList().toArray())[0].getTransferAmount(),
                (user2.getTransactionsList().toArray())[0].getCategory(),
                (user2.getTransactionsList().toArray())[0].getTransferAmount()
        );
    }
}
