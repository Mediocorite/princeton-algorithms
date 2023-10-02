package weekonepercolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final WeightedQuickUnionUF uf;
    private final boolean[][] grid;
    private final int n;
    private int openSites = 0;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Grid size must be greater than 0");
        }
        this.n = n;
        uf = new WeightedQuickUnionUF(n * n + 2);
        grid = new boolean[n][n];
    }

    public void open(int row, int col) {
        validateIndices(row, col);
        if (!isOpen(row, col)) {
            grid[row - 1][col - 1] = true;
            openSites++;

            // Connect to adjacent open sites
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int current = (row - 1) * n + col;
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (isValidIndex(newRow, newCol) && isOpen(newRow, newCol)) {
                    int adjacent = (newRow - 1) * n + newCol;
                    uf.union(current, adjacent);
                }
            }

            // Connect to virtual top and bottom
            if (row == 1) {
                uf.union(0, current);
            }
            if (row == n) {
                uf.union(n * n + 1, current);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        validateIndices(row, col);
        int current = (row - 1) * n + col;
        return uf.connected(0, current);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return uf.connected(0, n * n + 1);
    }

    private void validateIndices(int row, int col) {
        if (!isValidIndex(row, col)) {
            throw new IllegalArgumentException("Row and column indices must be between 1 and " + n);
        }
    }

    private boolean isValidIndex(int row, int col) {
        return row >= 1 && row <= n && col >= 1 && col <= n;
    }

    public static void main(String[] args) {
        // Test client can go here
    }
}
