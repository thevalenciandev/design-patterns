package com.thevalenciandev.gof.observer.v1;

import com.thevalenciandev.gof.observer.Balance;
import com.thevalenciandev.gof.observer.Transaction;

public class BankAccount {

    private Balance balance;
    private Transaction lastTransaction;

    private TransactionNotifier transactionNotifier;
    private OverdraftNotifier overdraftNotifier;

    private BankAccount(Balance balance) {
        this.balance = balance;
    }

    public static BankAccount of(Balance balance) {
        return new BankAccount(balance);
    }

    public void add(Transaction transaction) {
        lastTransaction = transaction;
        balance = balance.plus(transaction.value);
        if (transactionNotifier != null) transactionNotifier.update();
        if (overdraftNotifier != null) overdraftNotifier.update();
    }

    public Balance balance() {
        return balance;
    }

    public Transaction lastTransaction() {
        return lastTransaction;
    }

    public boolean isInOverdraft() {
        return balance.value < 0.0;
    }

    public void setTransactionNotifier(TransactionNotifier transactionNotifier) {
        this.transactionNotifier = transactionNotifier;
    }

    public void setOverdraftNotifier(OverdraftNotifier overdraftNotifier) {
        this.overdraftNotifier = overdraftNotifier;
    }
}