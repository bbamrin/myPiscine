package com.company;

import java.util.Scanner;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        User test1;
        User test2;

        test1 = new User("test1", 15432);
        test2 = new User("test2", 45673);
        System.out.printf(
                "user info\n  name: %s\n  balance: %s\n  id: %s\n\n",
                test1.getName(),
                test1.getBalance(),
                test1.getIdentifier()
        );
        System.out.printf(
                "user info\n  name: %s\n  balance: %s\n  id: %s\n",
                test2.getName(),
                test2.getBalance(),
                test2.getIdentifier()
        );
    }
}
