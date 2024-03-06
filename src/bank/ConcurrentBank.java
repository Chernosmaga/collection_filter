package bank;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentBank {
    private ConcurrentLinkedQueue<BankAccount> accounts = new ConcurrentLinkedQueue<>();

    public BankAccount createAccount(int amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAmount(amount);
        accounts.add(bankAccount);
        return bankAccount;
    }

    public void transfer(BankAccount account1, BankAccount account2, int amount) {
        synchronized (this) {
            account1.setAmount(account1.getBalance() - amount);
            account2.setAmount(account2.getBalance() + amount);
        }
    }

    public int getTotalBalance() {
        int sum = 0;
        for (BankAccount account: accounts) {
            sum += account.getBalance();
        }
        return sum;
    }

}
