package com.thevalenciandev.gof.decorator;

import com.thevalenciandev.gof.observer.Balance;
import com.thevalenciandev.gof.observer.Transaction;
import com.thevalenciandev.gof.observer.v2.BankAccount;
import com.thevalenciandev.gof.observer.v2.OverdraftNotifier;
import com.thevalenciandev.gof.observer.v2.TransactionNotifier;

public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = BankAccount.of(Balance.of(0));

        bankAccount.subscribe(MillisLatencyTrackerDecorator.track(new TransactionNotifier(bankAccount)));
        bankAccount.subscribe(MillisLatencyTrackerDecorator.track(new OverdraftNotifier(bankAccount)));

        bankAccount.add(Transaction.of(300));
        bankAccount.add(Transaction.of(-100));
        bankAccount.add(Transaction.of(-250));

    }
}
