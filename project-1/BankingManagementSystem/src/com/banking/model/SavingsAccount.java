package com.banking.model;

import java.time.LocalDate;
import java.util.Dictionary;

public class SavingsAccount extends Account {
    public SavingsAccount(int id, int customerId, double balance, LocalDate creationDate) {
        super(id, customerId, balance, creationDate);
        super.type = "savings";
    }

    public SavingsAccount(Dictionary<Integer, Customer> customers) {
        super("savings", customers);
    }
}