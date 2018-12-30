package com.thevalenciandev.gof.observer.v2;

import com.thevalenciandev.gof.observer.Balance;
import com.thevalenciandev.gof.observer.Transaction;
import org.junit.Test;

import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class BankAccountTest {

    BankAccount bankAccount = BankAccount.of(Balance.of(0));
    Observer observer1 = mock(Observer.class);
    Observer observer2 = mock(Observer.class);

    @Test
    public void notifiesAllObservers() {

        bankAccount.subscribe(observer1);
        bankAccount.subscribe(observer2);

        bankAccount.add(Transaction.of(123));

        Stream.of(observer1, observer2).forEach(observer -> verify(observer).update());
    }

    @Test
    public void unregistersObservers() {

        bankAccount.subscribe(observer1);

        bankAccount.add(Transaction.of(123));
        verify(observer1).update();

        bankAccount.unSubscribe(observer1);
        bankAccount.add(Transaction.of(456));
        verifyNoMoreInteractions(observer1);
    }
}