package com.thevalenciandev.gof.observer.v1;

public class TransactionNotifier {

    private final BankAccount bankAccount;

    public TransactionNotifier(BankAccount publisher) {
        this.bankAccount = publisher;
    }

    public void update() {
        System.out.println(String.format("Last transaction: %s. Balance: %s", bankAccount.lastTransaction(), bankAccount.balance()));
    }
}
