package com.banking.model;
import java.time.LocalDate;
import java.util.Dictionary;

import com.banking.exception.InsufficientBalanceException;
import com.banking.utility.*;

public class Account {
    protected static int nextId = 0;
    
    private int id;
    private int customerId;

    protected String type = "generic";
    protected double balance;
    protected LocalDate creationDate;

    public static void setNextId(int newNextId) {
        nextId = newNextId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
    }

    public int withdraw(double amt) throws InsufficientBalanceException {
        if (balance - amt >= 0.0) {
            balance -= amt;
            return 0;
        } else {
            throw new InsufficientBalanceException("Insufficient balance, requested " + amt + ", account has " + balance);
        }
    }

    public Account(int id, int customerId, double balance, LocalDate creationDate) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    protected Account(String type, Dictionary<Integer, Customer> customers) {
        Customer customer = null;
        int incomingCustomerId = 0;

        while (customer == null) {
            System.out.println("Enter customer ID: ");
            incomingCustomerId = InputUtility.getInt();
            customer = customers.get(incomingCustomerId);
            if (customer == null) {
                System.out.println("Invalid customer ID, try again: ");
            }
        }

        this.id = nextId++;
        this.customerId = incomingCustomerId;
        this.type = type;
        this.balance = 0;
        this.creationDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " | Type: " + this.type + " | Balance: $" + this.balance;
    }
}
