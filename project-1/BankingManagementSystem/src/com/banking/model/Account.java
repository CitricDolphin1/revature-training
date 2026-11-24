package com.banking.model;
import java.util.*;

public class Account {
    protected static int nextId = 0;
    
    private int id;
    private int customerId;

    protected String type = "Current";
    protected double balance;
    protected Date creationDate;

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
}
