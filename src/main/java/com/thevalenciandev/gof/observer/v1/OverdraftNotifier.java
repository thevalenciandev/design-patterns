package com.thevalenciandev.gof.observer.v1;

public class OverdraftNotifier {

    private final BankAccount bankAccount;

    public OverdraftNotifier(BankAccount bankAccountPublisher) {
        this.bankAccount = bankAccountPublisher;
    }

    public void update() {

        if (bankAccount.isInOverdraft())
            System.out.println("Account in overdraft! Balance: " + bankAccount.balance());
    }
}
