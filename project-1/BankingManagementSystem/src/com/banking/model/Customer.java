package com.banking.model;
import java.util.*;
import com.banking.utility.*;

public class Customer {
    public static int nextId = 0;
    public String name;
    
    private int id;
    private String email;
    private String phone;
    private Dictionary<Integer, Account> accounts = new Hashtable<>();

    public void setNextId(int newNextId) {
        nextId = newNextId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void addAccount(Account acct) {
        this.accounts.put(acct.getId(), acct);
    }

    public Account getAcct(int id) {
        return this.accounts.get(id);
    }

    public Customer(int id, String name, String email, String phone, Dictionary<Integer, Account> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accounts = accounts;
    }

    private Customer(String name, String email, String phone) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customer() {
        String name;
        String phone;

        System.out.println("Enter name: ");
        name = InputUtility.strInput();
        System.out.println("Enter phone number: ");
        phone = InputUtility.getPhone();

        System.out.println("Enter email address: ");
        String email = InputUtility.getEmail();

        this(name, email, phone);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Phone Number: " + phone;
    }

}
