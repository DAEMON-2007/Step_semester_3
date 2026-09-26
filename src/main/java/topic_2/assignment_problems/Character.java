package topic_2.assignment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        if (maxHealth < 0) {
            throw new IllegalArgumentException("Maximum health cannot be negative");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Damage cannot be negative");
        }
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Healing cannot be negative");
        }
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }
}
