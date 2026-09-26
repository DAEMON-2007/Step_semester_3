package topic_2.assignment_problems;

public class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
    }

    public void deposit(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit cannot be negative");
        }
        savings += amount;
    }

    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal cannot be negative");
        }
        if (amount <= savings) {
            savings -= amount;
        }
    }

    public int getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}
