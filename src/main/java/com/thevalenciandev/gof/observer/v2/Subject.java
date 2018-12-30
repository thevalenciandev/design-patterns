package com.thevalenciandev.gof.observer.v2;

public interface Subject {

    void subscribe(Observer observer);

    void unSubscribe(Observer observer);

    void notifyObservers();
}
