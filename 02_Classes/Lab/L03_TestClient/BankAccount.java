package Lab.L03_TestClient;
import java.security.InvalidParameterException;

class BankAccount {
    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new InvalidParameterException("Amount should be positive!");
        } else {
            this.balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new InvalidParameterException("Amount should be positive!");
        } else if (amount > this.balance) {
            throw new IllegalStateException("Insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
