package Lab.L03_TestClient;

import java.security.InvalidParameterException;
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
                    createAccount(params, accounts);
                    break;
                case "Deposit":
                    depositFunds(params, accounts);
                    break;
                case "Withdraw":
                    withdrawFunds(params, accounts);
                    break;
                case "Print":
                    printId(params, accounts);
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void printId(
            String[] params, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(params[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            System.out.printf("Account %s, balance %.2f%n", acc, acc.getBalance());
        }
    }

    private static void withdrawFunds(
            String[] params, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(params[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            int amount = Integer.parseInt(params[2]);
            try {
                accounts.get(id).withdraw(amount);
            } catch (InvalidParameterException | IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void depositFunds(
            String[] params, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(params[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            int amount = Integer.parseInt(params[2]);
            try {
                accounts.get(id).deposit(amount);
            } catch (InvalidParameterException ipe) {
                System.out.println(ipe.getMessage());
            }
        }
    }

    private static void createAccount(
            String[] params, Map<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(params[1]);
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount acc = new BankAccount();
            acc.setId(id);
            accounts.put(id, acc);
        }
    }
}
