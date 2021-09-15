package org.xpdojo.bank;

public class Account {
    public Money balance = new Money(0);

    public void deposit(Money i) {
        balance = balance.add(i);
    }

    public void withdraw(Money i) throws InsufficientBalanceException {
        if (balance.lessThan(i)) {
            throw new InsufficientBalanceException();
        }
        balance = balance.subtract(i);
    }
}
