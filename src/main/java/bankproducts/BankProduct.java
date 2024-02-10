package bankproducts;

import java.util.logging.Logger;

public abstract class BankProduct {
    protected String currency;
    protected double balance;
    protected String name;
    private boolean closed;

    public BankProduct(String currency, double balance, String name) {
        this.currency = currency;
        this.balance = balance;
        this.name = name;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public double checkBalance() {
        return this.balance;
    }
}