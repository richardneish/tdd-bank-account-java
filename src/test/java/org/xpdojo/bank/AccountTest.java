package org.xpdojo.bank;

import org.assertj.core.api.AbstractIntegerAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void startingBalanceIsZero() {
        Account account = new Account();
        assertThat(account.balance).isEqualTo(0);
    }

    @Test
    public void depositAnAmountToIncreaseTheBalanceByTheSameAmount() {
        Account account = new Account();
        account.deposit(100);
        assertThat(account.balance).isEqualTo(100);
    }

    @Test
    public void depositMultipleAmounts() {
        Account account = new Account();
        account.deposit(100);
        account.deposit(300);
        assertThat(account.balance).isEqualTo(400);
    }

    @Test
    public void withdrawChangesBalance() {
        Account account = new Account();
        account.deposit(400);
        assertThat(account.balance).isEqualTo(400);
        account.withdraw(200);
        assertThat(account.balance).isEqualTo(200);
    }
}
