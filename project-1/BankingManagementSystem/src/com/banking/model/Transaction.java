package com.banking.model;
import java.util.*;

import com.banking.exception.*;
import com.banking.utility.InputUtility;

public class Transaction {
    private static int nextId = 0;
    private static List<Transaction> history = new ArrayList<Transaction>();

    private int id;
    private String type; //Deposit, Withdrawal, Transfer
    private int toAcct;
    private int fromAcct;
    private double amt; //Amount

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

    public int transact(Dictionary<Integer, Account> accounts) throws InvalidAccountException, InsufficientBalanceException {
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("3. Transfer");
        System.out.println("4. Cancel");
        System.out.println();
        int selection = InputUtility.getMenuOption(4);

        try {
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
        } catch (InvalidAccountException e) {
            return 1;
        } catch (InsufficientBalanceException e) {
            return 1;
        }

        //Sanity check, this should actually be unreachable
        return 0;
    }

    private int deposit(Dictionary<Integer, Account> accounts) throws InvalidAccountException {
        System.out.println("Enter account number: ");
        int acctNumber = InputUtility.getInt();
        Account acct = getAccount(accounts, acctNumber);
        if (acct == null) {
            throw new InvalidAccountException("Invalid account number.");
        }

        System.out.println("Enter deposit amount: ");
        double depositAmt = InputUtility.getFundAmt();

        acct.deposit(depositAmt);
        history.add(new Transaction(nextId++, "deposit", acctNumber, depositAmt));
        return 0;
    }

    private int withdraw(Dictionary<Integer, Account> accounts) throws InvalidAccountException, InsufficientBalanceException {
        System.out.println("Enter account number :");
        int acctNumber = InputUtility.getInt();
        Account acct = getAccount(accounts, acctNumber);
        if (acct == null) {
            throw new InvalidAccountException("Invalid account number.");
        }

        System.out.println("Enter withdrawal amount: ");
        double withdrawAmt = InputUtility.getFundAmt();

        acct.withdraw(withdrawAmt);

        history.add(new Transaction(nextId++, "withdrawal", acctNumber, withdrawAmt));
        return 0;
    }

    private int transfer(Dictionary<Integer, Account> accounts) throws InvalidAccountException, InsufficientBalanceException {
        System.out.println("Enter source account number: ");
        int srcAcctNumber = InputUtility.getInt();
        Account srcAcct = getAccount(accounts, srcAcctNumber);
        if (srcAcct == null) {
            throw new InvalidAccountException("Invalid account number.");
        }

        System.out.println("Enter destination account number: ");
        int destAcctNumber = InputUtility.getInt();
        Account destAcct = getAccount(accounts, destAcctNumber);
        if (destAcct == null) {
            System.out.println("invalid account number, returning to menu.");
            return 1;
        }

        System.out.println("Enter amount to transfer from " + srcAcctNumber + " to " + destAcctNumber + ": ");
        double amt = InputUtility.getFundAmt();

        int withdrawStatus = srcAcct.withdraw(amt);
        if (withdrawStatus == 1) {
            System.out.println("Insufficient funds, returning to menu.");
            return 1;
        }
        destAcct.deposit(amt);

        history.add(new Transaction(nextId++, "transfer", srcAcctNumber, destAcctNumber, amt));
        return 0;
    }

    private Account getAccount(Dictionary<Integer, Account> accounts, int id) {
        try {
            return accounts.get(id);
        } catch (Exception e) {
            return null;
        }
    }
}
