package com.banking.model;
import java.util.*;
import com.banking.utility.InputUtility;

public class Transaction {
    private static int nextId = 0;
    private static List<Transaction> history = new ArrayList<Transaction>();

    private int id;
    private String type; //Deposit, Withdrawal, Transfer
    private int toAcct;
    private int fromAcct;
    private double amt; //Ammount

    public List<Transaction> getHistory() {
        return history;
    }

    public Transaction(int id, String type, int toAcct, int fromAcct, double amt) {
        this.id = id;
        this.type = type;
        this.toAcct = toAcct;
        this.fromAcct = fromAcct;
        this.amt = amt;
        history.add(this);
    }

    public Transaction(int id, String type, int toAcct, double amt) {
        this.id = id;
        this.type = type;
        this.toAcct = toAcct;
        this.amt = amt;
        history.add(this);
    }

    public int transact(Dictionary<Integer, Account> accounts) {
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("3. Transfer");
        System.out.println("4. Cancel");
        System.out.println();
        int selection = InputUtility.getMenuOption(4);

        switch (selection) {
            case 1:
                return deposit(accounts);
            case 2:
                return withdraw(accounts);
            case 3:
                return transfer(accounts);
            case 4:
                return 0;
        }

        return 0;
    }

    private int deposit(Dictionary<Integer, Account> accounts) {
        return 0;
    }

    private int withdraw(Dictionary<Integer, Account> accounts) {
        return 0;
    }

    private int transfer(Dictionary<Integer, Account> accounts) {
        return 0;
    }
}
