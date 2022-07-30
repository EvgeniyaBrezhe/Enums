package ua.hillel.enums;

import ua.hillel.enums.model.Store;
import ua.hillel.enums.model.User;

import java.util.Scanner;

import static ua.hillel.enums.model.Position.*;

public class Main {

    public static void main(String[] args) {
        User user1 = new User("user1", "11", "User 1", DIRECTOR);
        User user2 = new User("user2", "11", "User 2", ADMINISTRATOR);
        User user3 = new User("user3", "11", "User 3", MANAGER);
        User user4 = new User("user4", "11", "User 4", CLIENT);
        User user5 = new User("user5", "11", "User 5", ANONYMOUS);

        User[] users = {user1, user2, user3, user4, user5};

        Store myStore = new Store("MyOnlineShop", "https://myonlineshop.com", users);

        while (true) {
            tryLogin(myStore);
        }
    }

    public static void tryLogin(Store store) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your login");
        String login = myObj.nextLine();
        System.out.println("Enter your password");
        String password = myObj.nextLine();

        if (store.login(login, password)) {
            store.getCurrentUserRights(store.getAuthorisedUser());
            store.logout(store.getAuthorisedUser());
        } else {
            System.out.println("Incorrect login or password");
        }
    }
}

