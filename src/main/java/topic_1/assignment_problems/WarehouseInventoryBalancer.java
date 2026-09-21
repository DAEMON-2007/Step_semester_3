package topic_1.assignment_problems;

public class WarehouseInventoryBalancer {
    public void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("Sections must be non-null and have equal length.");
        }
        if (sectionA.length == 0) {
            System.out.println("Sections are empty");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int index = 0; index < sectionA.length; index++) {
            totalA += sectionA[index];
            totalB += sectionB[index];

            if (sectionA[index] > highestQuantity) {
                highestQuantity = sectionA[index];
                highestSection = "Section A";
                highestIndex = index;
            }
            if (sectionB[index] > highestQuantity) {
                highestQuantity = sectionB[index];
                highestSection = "Section B";
                highestIndex = index;
            }
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, index %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestIndex);
    }

    public static void main(String[] args) {
        WarehouseInventoryBalancer balancer = new WarehouseInventoryBalancer();
        balancer.analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
