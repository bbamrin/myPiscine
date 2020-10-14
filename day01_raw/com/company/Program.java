package com.company;

import java.util.Scanner;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        UserList userList;
        Integer      i;
        Integer      lstSize;
        User         someUser;
        User         someOtherUser;


        //доделать вывод и протестировать линкед лист
        /*i = -1;
        lstSize = 16;
        userList = new UsersArrayList();
        while (++i < lstSize) {
            System.out.printf("user number: %d\n", userList.getUserNumber());
            userList.addUser(new User(Integer.toString(i), 100 * i));
        }
        System.out.printf("user number: %d\n", userList.getUserNumber());
        i = -1;
        while (++i < lstSize) {
            System.out.printf(
                    "\nuser info\n  name: %s\n  balance: %s\n  id: %s\n",
                    userList.getUserByIndex(i).getName(),
                    userList.getUserByIndex(i).getBalance(),
                    userList.getUserByIndex(i).getIdentifier()
            );
        }
        i = -1;
        someUser = userList.getUserByIndex(6);
        someOtherUser = new User("someOtherUser", 123456);
        System.out.printf(
                "user info\n  name: %s\n  balance: %s\n  id: %s\n\n",
                userList.getUserById(someUser.getIdentifier()).getName(),
                userList.getUserById(someUser.getIdentifier()).getBalance(),
                userList.getUserById(someUser.getIdentifier()).getIdentifier()
        );

        System.out.printf(
                "user info\n  name: %s\n  balance: %s\n  id: %s\n\n",
                userList.getUserById(someOtherUser.getIdentifier()).getName(),
                userList.getUserById(someOtherUser.getIdentifier()).getBalance(),
                userList.getUserById(someOtherUser.getIdentifier()).getIdentifier()
        );*/
    }
}
