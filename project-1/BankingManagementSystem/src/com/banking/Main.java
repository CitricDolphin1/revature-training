package com.banking;
import java.util.*;
import com.banking.utility.*;

public class Main {
    public static void main(String[] args) {
        while (true) {
            showMenu();
            int selection = InputUtility.getMenuOption(9);
        }
    }

    private static void showMenu() {
        System.out.println("====================================");
        System.out.println("       BANKING MANAGEMENT SYSTEM");
        System.out.println("====================================");
        System.out.println();
        System.out.println("1. Create customer");
        System.out.println("2. Create Bank Account");
        System.out.println("3. View Customer Details");
        System.out.println("4. Deposit Money");
        System.out.println("5. Withdraw Money");
        System.out.println("6. Check Account Balance");
        System.out.println("7. Transfer Money");
        System.out.println("8. View Transaction History");
        System.out.println("9. Exit");
        System.out.println();
    }
}
