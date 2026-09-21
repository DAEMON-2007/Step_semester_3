package topic_2.assignment_problems;

public class ProductInventoryCsvParser {
    public void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3
                || fields[0].trim().isEmpty()
                || fields[1].trim().isEmpty()
                || fields[2].trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.printf("Product: %s | SKU: %s | Qty: %s%n",
                fields[0].trim(), fields[1].trim(), fields[2].trim());
    }

    public static void main(String[] args) {
        ProductInventoryCsvParser parser = new ProductInventoryCsvParser();
        parser.parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parser.parseInventoryRecord("Wireless Mouse,WM-2201");
    }
}
