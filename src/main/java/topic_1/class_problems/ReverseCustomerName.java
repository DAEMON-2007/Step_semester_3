package topic_1.class_problems;

public class ReverseCustomerName {
    public String reverseCustomerName(String customerName) {
        if (customerName == null) {
            throw new IllegalArgumentException("Customer name cannot be null.");
        }

        return new StringBuilder(customerName).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseCustomerName reverser = new ReverseCustomerName();
        String customerName = "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverser.reverseCustomerName(customerName));
    }
}
