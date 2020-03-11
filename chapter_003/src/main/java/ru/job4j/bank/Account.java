package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

    public boolean transfer(Account outAccount, double amount) {
        boolean result = false;
        if (balance >= amount) {
            this.balance -= amount;
            outAccount.balance += amount;
            result = true;
        }
        return result;
    }
}