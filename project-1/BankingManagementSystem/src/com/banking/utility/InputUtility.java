package com.banking.utility;
import java.util.*;

public class InputUtility {

    private static Scanner scanner = new Scanner(System.in);

    public static int getMenuOption(List<Integer> options) {
        int selection = -1;

        while (!options.contains(selection)) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            try {
                selection = Integer.parseInt(input);
            } catch(Exception e) {
                System.out.println("Invalid selection.");
                continue;
            }

            if (!options.contains(selection)) {
                System.out.println("Invalid selection.");
            }
        }

        return selection;
    }


    public static double getFundAmt() {
        double amt = -1.0D;
        Boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter ammount: ");
            String input = scanner.nextLine();
            
            try {
                amt = Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Invalid ammount.");
                continue;
            }

            //Enforce only two decimal places
            if ((amt * 100) % 1 != 0.0) {
                System.out.println("Invalid ammount.");
                continue;
            }

            if (amt > 0.0) {
                isValid = true;
                continue;
            }
        }

        return amt;
    }


    public static int getInt() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    public static double getDouble() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }
    }

    public static String getEmail() {
        while (true) {
            String input = scanner.nextLine();
            if (isValidEmail(input)) {
                return input;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    private static Boolean isValidEmail(String email) {
        if (
            email == "" ||
            email == null ||
            email.length() < 6 || //shortest possible valid email format: a@b.co
            email.charAt(0) == '@'
        )
        {
            return false;
        }
        
        Boolean foundAtSign = false;
        Boolean hasDot = false;
        int charsAfterDot = 0;

        for (int i = 0; i < email.length(); i++) {
            char letter = email.charAt(i);
            
            if (letter == '@') {
                if (foundAtSign) {
                    return false;
                } else {
                    foundAtSign = true;
                    continue;
                }
            }

            if (foundAtSign && letter == '.') {
                hasDot = true;
                continue;
            }

            if (hasDot) {
                charsAfterDot++;
            }

            if (charsAfterDot >= 2) {
                return true;
            }
        }

        return false;
    }
}
