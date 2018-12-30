package com.thevalenciandev.gof.observer.v2;

public class OverdraftNotifier implements Observer {

    private final BankAccount bankAccount;

    public OverdraftNotifier(BankAccount bankAccountPublisher) {
        this.bankAccount = bankAccountPublisher;
    }

    @Override
    public void update() {

        if (bankAccount.isInOverdraft())
            System.out.println("Account in overdraft! Balance: " + bankAccount.balance());
    }
}
