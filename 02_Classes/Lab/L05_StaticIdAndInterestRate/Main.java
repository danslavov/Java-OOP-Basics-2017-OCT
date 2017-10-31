package Lab.L05_StaticIdAndInterestRate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> accounts = new HashMap<>();
        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] params = input.split("\\s+");
            String command = params[0];

            switch (command) {
                case "Create":
                    createAccount(accounts);
                    break;
                case "Deposit":
                    depositFunds(accounts, params);
                    break;
                case "SetInterest":
                    double rate = Double.parseDouble(params[1]);
                    setInterest(rate);
                    break;
                case "GetInterest":
                    getInterest(accounts, params);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void getInterest(Map<Integer, BankAccount> accounts, String[] params) {
        int id = Integer.parseInt(params[1]);
        int years = Integer.parseInt(params[2]);
        if (accounts.containsKey(id)) {
            double interest = accounts.get(id).getInterest(years);
            System.out.printf("%.2f%n", interest);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void setInterest(double rate) {
        BankAccount.setInterestRate(rate);
    }

    private static void depositFunds(
            Map<Integer, BankAccount> accounts, String[] params) {
        int id = Integer.parseInt(params[1]);
        double amount = Double.parseDouble(params[2]);
        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(amount);
            System.out.printf("Deposited %.0f to %s%n", amount, accounts.get(id));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount(Map<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account %s created%n", account);
    }
}
