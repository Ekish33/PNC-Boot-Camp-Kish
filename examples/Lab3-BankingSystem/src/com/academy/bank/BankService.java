package com.academy.bank;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BankService {

    private static final int MAX_CUSTOMERS = 50;
    private static final int MAX_ACCOUNTS = 100;
    private static final int MAX_TRANSACTIONS = 500;

    private final Customer[] customers = new Customer[MAX_CUSTOMERS];
    private final Account[] accounts = new Account[MAX_ACCOUNTS];
    private final Transaction[] transactions = new Transaction[MAX_TRANSACTIONS];

    private int customerCount = 0;
    private int accountCount = 0;
    private int transactionCount = 0;
    private int nextAccountNumber = 10001;
    private int nextTransactionNumber = 1;

    private final Scanner scanner;

    public BankService(Scanner scanner) {
        this.scanner = scanner;
    }
//done
    public void createCustomer() {
        System.out.print("Customer ID : ");
        String customerId = scanner.nextLine();
        if(findCustomer(customerId) != null) {
            System.out.println("Customer ID already exists. Please try again.");
            return;
        }
        System.out.print("Customer Name : ");
        String customerName = scanner.nextLine();
        System.out.print("Customer Email : ");
        String customerEmail = scanner.nextLine();
        System.out.print("Customer Phone : ");
        String customerPhone = scanner.nextLine();
        Customer customer = new Customer(customerId, customerName, customerEmail, customerPhone);
        customers[customerCount++] = customer;
        System.out.println("Customer Created Successfully.");
        // TODO: read customerId / name / email / phone; reject duplicate IDs
        // TODO: store new Customer; print "Customer Created Successfully."
    }

    public void createSavingsAccount() {
    Customer customer = readExistingCustomer();
    if (customer == null) {
        return;
    }
    double initialBalance = readPositiveAmount("Initial Balance : ");
    double interestRate = readPositiveAmount("Interest Rate : ");
    String accountNumber = String.valueOf(nextAccountNumber++);
    SavingsAccount account = new SavingsAccount(accountNumber, initialBalance, customer, interestRate);
    accounts[accountCount++] = account;
    System.out.println("Savings Account Created Successfully.");
}

    public void createCurrentAccount() {
    Customer customer = readExistingCustomer();
    if (customer == null) {
        return;
    }
    double initialBalance = readPositiveAmount("Initial Balance : ");
    double transactionFee = readPositiveAmount("Transaction Fee : ");
    String accountNumber = String.valueOf(nextAccountNumber++);
    CurrentAccount account = new CurrentAccount(accountNumber, initialBalance, customer, transactionFee);
    accounts[accountCount++] = account;
    System.out.println("Current Account Created Successfully.");
}

    public void deposit() {
    Account account = readExistingAccount();
    if (account == null) {
        return;
    }
    double amount = readPositiveAmount("Deposit Amount : ");
    account.deposit(amount);
    recordTransaction(account.getAccountNumber(), amount, "DEPOSIT");
    System.out.printf("Updated Balance : %.2f%n", account.getBalance());
}

    public void withdraw() {
    Account account = readExistingAccount();
    if (account == null) {
        return;
    }
    double amount = readPositiveAmount("Withdraw Amount : ");
    boolean success = account.withdraw(amount);
    if (!success) {
        System.out.println("Withdrawal failed. Insufficient balance.");
        return;
    }
    recordTransaction(account.getAccountNumber(), amount, "WITHDRAW");
    if (account instanceof CurrentAccount current) {
        System.out.printf("Fee Charged : %.2f%n", current.getTransactionFee());
        System.out.printf("Total Deducted : %.2f%n", amount + current.getTransactionFee());
    }
    System.out.printf("Updated Balance : %.2f%n", account.getBalance());
}

    public void displayAccounts() {
    if (accountCount == 0) {
        System.out.println("No accounts available.");
        return;
    }
    System.out.println("----------------------------------");
    for (int i = 0; i < accountCount; i++) {
        accounts[i].displayAccount();
        System.out.println("----------------------------------");
    }
}

    public void displayCustomers() {
        if (customerCount == 0) {
            System.out.println("No customers available.");
            return;
        }

        System.out.println("----------------------------------");
        for (int i = 0; i < customerCount; i++) {
            customers[i].display();
            System.out.println("----------------------------------");
        }
    }

    public void transferMoney() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayTransactionHistory() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayAccountsSortedByBalance() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void displayHighestBalanceCustomer() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    public void generateAccountSummaryReport() {
        System.out.println("Bonus / full-path feature — implement after core TODOs.");
    }

    private Customer readExistingCustomer() {
        if (customerCount == 0) {
            System.out.println("Create a customer first.");
            return null;
        }

        System.out.print("Customer ID : ");
        String customerId = scanner.nextLine().trim();
        Customer customer = findCustomer(customerId);

        if (customer == null) {
            System.out.println("Customer not found.");
        }

        return customer;
    }

    private Account readExistingAccount() {
        if (accountCount == 0) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.print("Account Number : ");
        String accountNumber = scanner.nextLine().trim();
        Account account = findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
        }

        return account;
    }

    private Customer findCustomer(String customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equalsIgnoreCase(customerId)) {
                return customers[i];
            }
        }
        return null;
    }

    private Account findAccount(String accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    private void recordTransaction(String accountNumber, double amount, String type) {
        if (transactionCount >= MAX_TRANSACTIONS) {
            return;
        }

        String transactionId = "T" + nextTransactionNumber++;
        String date = LocalDate.now().toString();
        transactions[transactionCount++] = new Transaction(transactionId, amount, type, date, accountNumber);
    }

    private double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value < 0) {
                    System.out.println("Amount must not be negative.");
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid amount. Please try again.");
            }
        }
    }
}
