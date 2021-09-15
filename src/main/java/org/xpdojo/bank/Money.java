package org.xpdojo.bank;

import java.util.Objects;

/**
 * Immutable class to represent Money as a concept.
 * This class should have no accessor methods.
 */
public class Money {
    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public Money add(Money i) {
        return new Money(value + i.value);
    }

    public Money subtract(Money i) {
        return new Money(value - i.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean lessThan(Money i) {
        return value < i.value;
    }
}
