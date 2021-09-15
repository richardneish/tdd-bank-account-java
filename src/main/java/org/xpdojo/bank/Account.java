package org.xpdojo.bank;

public class Account {
    public Money balance = new Money(0);

    public void deposit(Money i) {
        balance = balance.add(i);
    }

    public void withdraw(Money i) {
        balance = balance.subtract(i);
    }
}
