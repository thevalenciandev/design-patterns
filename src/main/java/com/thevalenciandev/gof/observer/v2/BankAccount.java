package com.thevalenciandev.gof.observer.v2;

import com.thevalenciandev.gof.observer.Balance;
import com.thevalenciandev.gof.observer.Transaction;

import java.util.*;

public class BankAccount implements Subject {

    private Balance balance;
    private Transaction lastTransaction;

    private final Collection<Observer> observers = new ArrayList<>();

    private BankAccount(Balance balance) {
        this.balance = balance;
    }

    public static BankAccount of(Balance balance) {
        return new BankAccount(balance);
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void add(Transaction transaction) {
        lastTransaction = transaction;
        balance = balance.plus(transaction.value);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
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
}
