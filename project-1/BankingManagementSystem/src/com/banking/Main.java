package com.banking;
import java.util.*;
import com.banking.utility.*;
import com.banking.model.*;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println();
            BankOperations.showMenu();
            int selection = InputUtility.getMenuOption(9);

            switch (selection) {
                case 1: {
                    BankOperations.createCustomer();
                    break;
                }
                case 2: {
                    BankOperations.createAccount();
                    break;
                }
            }
        }
    }
}
