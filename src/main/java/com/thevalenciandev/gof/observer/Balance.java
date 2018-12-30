package com.thevalenciandev.gof.observer;

public class Balance {

    public final double value;

    private Balance(double value) {
        this.value = value;
    }

    public static Balance of(double balance) {
        return new Balance(balance);
    }

    @Override
    public String toString() {
        return value + " pounds";
    }

    public Balance plus(double value) {
        return Balance.of(this.value + value);
    }
}
