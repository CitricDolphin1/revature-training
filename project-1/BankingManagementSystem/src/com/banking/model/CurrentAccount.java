package com.banking.model;

import java.time.LocalDate;
import java.util.Dictionary;

public class CurrentAccount extends Account {
    public CurrentAccount(int id, int customerId, double balance, LocalDate creationDate) {
        super(id, customerId, balance, creationDate);
        super.type = "current";
    }

    public CurrentAccount(Dictionary<Integer, Customer> customers) {
        super("current", customers);
    }
}