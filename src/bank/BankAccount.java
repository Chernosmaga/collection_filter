package bank;

import java.util.Objects;

public class BankAccount {
    private int amount;

    public int deposit(int newAmount) {
        synchronized (this) {
            return amount + newAmount;
        }
    }

    public int withdraw(int newAmount) {
        synchronized (this) {
            return amount - newAmount;
        }
    }

    public int getBalance() {
        synchronized (this) {
            return amount;
        }
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
