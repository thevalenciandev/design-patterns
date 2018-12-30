package com.thevalenciandev.gof.observer;

public class Transaction {

    public final double value;

    private Transaction(double value) {
        this.value = value;
    }

    public static Transaction of(double value) {
        return new Transaction(value);
    }

    @Override
    public String toString() {
        return value + " pounds";
    }
}
