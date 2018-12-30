package com.thevalenciandev.gof.observer.v2;

import com.thevalenciandev.gof.observer.Balance;
import com.thevalenciandev.gof.observer.Transaction;

public class Main {

    public static void main(String[] args) {

        BankAccount bankAccount = BankAccount.of(Balance.of(0));

        bankAccount.subscribe(new TransactionNotifier(bankAccount));
        bankAccount.subscribe(new OverdraftNotifier(bankAccount));

        bankAccount.add(Transaction.of(300));
        bankAccount.add(Transaction.of(-100));
        bankAccount.add(Transaction.of(-250));

    }
}
