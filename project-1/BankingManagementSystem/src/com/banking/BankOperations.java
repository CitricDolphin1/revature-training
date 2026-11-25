package com.banking;

import java.util.Dictionary;
import java.util.Hashtable;

import com.banking.model.*;
import com.banking.utility.*;

public class BankOperations {

    static Dictionary<Integer, Customer> customers = new Hashtable<>();
    static Dictionary<Integer, Account> accounts = new Hashtable<>();
    
    public static void showMenu() {
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

    public static void createCustomer() {
        System.out.println();
        Customer newCustomer = new Customer();
        customers.put(newCustomer.getId(), newCustomer);
        
        System.out.println(newCustomer);
        return;
    }

    public static void createAccount() {
        if (customers.size() == 0) {
            System.out.println();
            System.out.println("Can not create an account without customers.");
            System.out.println();
            return;
        }

        System.out.println();
        System.out.println("Choose account type:");
        System.out.println("1. Current");
        System.out.println("2. Savings");
        int selection = InputUtility.getMenuOption(2);
        Account newAccount = null;

        switch (selection) {
            case 1: {
                newAccount = new CurrentAccount(customers);
                accounts.put(newAccount.getId(), newAccount);
                break;
            }
            case 2: {
                newAccount = new SavingsAccount(customers);
                accounts.put(newAccount.getId(), newAccount);
                break;
            }
        }

        System.out.println(newAccount);
        return;
    }

}
