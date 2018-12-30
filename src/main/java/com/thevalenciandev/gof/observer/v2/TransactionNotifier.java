package com.thevalenciandev.gof.observer.v2;

public class TransactionNotifier implements Observer {

    private final BankAccount bankAccount;

    public TransactionNotifier(BankAccount publisher) {
        this.bankAccount = publisher;
    }

    @Override
    public void update() {
        System.out.println(String.format("Last transaction: %s. Balance: %s", bankAccount.lastTransaction(), bankAccount.balance()));
    }
}
