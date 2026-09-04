package com.academy.bank;

public abstract class Account {

    private String accountNumber;
    private double balance;
    private Customer customer;

    protected Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
//i did this too
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        else {
            balance += amount;
        }
        // TODO: reject amount <= 0; otherwise add amount to balance
    }
//I did this
    public boolean withdraw(double amount) {
        // TODO: reject amount <= 0
        if (amount <= 0) {
            return false;
        }
        else{
            double totalDeduction = amount + calculateCharges();
        // TODO: totalDeduction = amount + calculateCharges(); fail if > balance
                if (totalDeduction > balance) {
                    return false;
                }
            return true;
            }
        // TODO: subtract totalDeduction from balance; return true/false
    }

    public abstract void displayAccount();

    public double calculateCharges() {
        return 0.0;
    }

    public double calculateInterest() {
        return 0.0;
    }

    public String getAccountType() {
        return "Account";
    }
}
