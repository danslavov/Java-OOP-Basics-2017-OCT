package Lab.L05_StaticIdAndInterestRate;

class BankAccount {
    private static final double DEFAULT_INTEREST = 0.2;
    private static double interestRate = DEFAULT_INTEREST;
    private static int accountNumber;

    private int id;
    private double balance;

    public static void setInterestRate(double rate) {
        if (rate > 0) {
            interestRate = rate;
        } else {
            throw new IllegalArgumentException("Rate should be more than 0");
        }
    }

    public BankAccount() {
        this.id = ++accountNumber;
    }

    public int getId() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterest(int years) {
        if (years > 0) {
            return interestRate * this.balance * years;
        } else {
            throw new IllegalArgumentException("Years should be more than 0");
        }
    }

    public void deposit(double amount) {
        if (amount >= 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Amount should be positive");
        }
    }

    public void withdraw(double amount) {   // not needed for this problem
        if (amount >= 0) {
            if (balance >= amount) {
                this.balance -= amount;
            } else {
                throw new IllegalStateException("Insufficient balance");
            }
        } else {
            throw new IllegalArgumentException("Amount should be positive");
        }
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
