package org.xpdojo.bank;

import org.assertj.core.api.AbstractIntegerAssert;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void startingBalanceIsZero() {
        Account account = new Account();
        assertThat(account.balance).isEqualTo(new Money(0));
    }

    @Test
    public void depositAnAmountToIncreaseTheBalanceByTheSameAmount() {
        Account account = new Account();
        account.deposit(new Money(100));
        assertThat(account.balance).isEqualTo(new Money(100));
    }

    @Test
    public void depositMultipleAmounts() {
        Account account = new Account();
        account.deposit(new Money(100));
        account.deposit(new Money(300));
        assertThat(account.balance).isEqualTo(new Money(400));
    }

    @Test
    public void withdrawChangesBalance() throws InsufficientBalanceException {
        Account account = new Account();
        account.deposit(new Money(400));
        assertThat(account.balance).isEqualTo(new Money(400));
        account.withdraw(new Money(200));
        assertThat(account.balance).isEqualTo(new Money(200));
    }

    @Test
    public void withdrawFailsForInsufficientBalance() {
        Account account = new Account();
        Money initialBalance = new Money(100);
        account.deposit(initialBalance);
        assertThat(account.balance).isEqualTo(initialBalance);
        assertThrows(InsufficientBalanceException.class, () -> account.withdraw(new Money(200)));
        assertThat(account.balance).isEqualTo(initialBalance);
    }
}
