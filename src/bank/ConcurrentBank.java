package bank;

import exception.TransactionException;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class ConcurrentBank {
    private ConcurrentLinkedQueue<BankAccount> accounts = new ConcurrentLinkedQueue<>();
    private Semaphore semaphore = new Semaphore(1);

    public BankAccount createAccount(int amount) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAmount(amount);
        accounts.add(bankAccount);
        return bankAccount;
    }

    public void transfer(BankAccount account1, BankAccount account2, int amount) {
        try {
            semaphore.acquire();
            if (account1.getBalance() - amount < 0) {
                throw new TransactionException("Ошибка транзакции");
            }
            account1.setAmount(account1.getBalance() - amount);
            System.out.println(account1.getBalance());
            account2.setAmount(account2.getBalance() + amount);
            System.out.println(account2.getBalance());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
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
