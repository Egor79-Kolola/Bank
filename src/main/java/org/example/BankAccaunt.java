package org.example;

public class BankAccaunt {
    private int balance;
    private final int limit;

    public BankAccaunt(int balance, int limit) {
        this.balance = balance;
        this.limit = limit;
    }

    public int deposit(int amount){
        balance += amount;
        return balance;
    }

    public int withdraw(int amount){
        if (amount > limit) throw new IllegalArgumentException("Превышен лимит суммы");
        if (amount == 0) throw new IllegalArgumentException("Не верная сумма");
        balance -= amount;
        return balance;
    }

}