package topic_2.assignment_problems;

public class ShoppingCart {
    private static final int MAX_ITEMS = 100;
    private final String id;
    private final double[] prices;
    private int itemCount;

    public ShoppingCart(String id, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.id = id;
        prices = new double[Math.min(capacity, MAX_ITEMS)];
    }

    public void addItem(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (itemCount == prices.length) {
            throw new IllegalStateException("Shopping cart is full");
        }
        prices[itemCount++] = price;
    }

    public double getTotal() {
        double total = 0;
        for (int index = 0; index < itemCount; index++) {
            total += prices[index];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getId() {
        return id;
    }
}
