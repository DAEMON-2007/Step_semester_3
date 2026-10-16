package topic_5.assignment_problems;

public class BusiestBusRow {
    private BusiestBusRow() {
    }

    public static RowSummary busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = -1;

        for (int row = 0; row < grid.length; row++) {
            int rowTotal = 0;
            for (int seats : grid[row]) {
                rowTotal += seats;
            }
            if (rowTotal > bestTotal) {
                bestTotal = rowTotal;
                bestRow = row;
            }
        }

        return new RowSummary(bestRow, bestTotal);
    }

    public record RowSummary(int row, int total) {
    }
}
