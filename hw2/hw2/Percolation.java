package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int count;
    private int top;
    private int bottom;

    private WeightedQuickUnionUF wqu;
    private WeightedQuickUnionUF wqu2; // without bottom site

    public Percolation(int N) {
        if (N <= 0) {
            throw new java.lang.IllegalArgumentException("index " + N + " is not greater than 0");
        }
        grid = new boolean[N][N];
        count = 0;
        wqu = new WeightedQuickUnionUF(N * N + 2);
        wqu2 = new WeightedQuickUnionUF(N * N + 1);
        top = N * N;
        bottom = N * N + 1;
    }

    public void open(int row, int col) {
        outOfBound(row, col);
        if (grid[row][col]) {
            return;
        }
        grid[row][col] = true;
        count++;

        int p = xyTo1D(row, col);
        if (row > 0 && isOpen(row - 1, col)) {
            wqu.union(p - grid.length, p);
            wqu2.union(p - grid.length, p);
        }
        if (row < grid.length - 1 && isOpen(row + 1, col)) {
            wqu.union(p, p + grid.length);
            wqu2.union(p, p + grid.length);
        }
        if (col > 0 && isOpen(row, col - 1)) {
            wqu.union(p - 1, p);
            wqu2.union(p - 1, p);
        }
        if (col < grid.length - 1 && isOpen(row, col + 1)) {
            wqu.union(p, p + 1);
            wqu2.union(p, p + 1);
        }

        // top row cases, connect to virtual top site
        if (row == 0) {
            wqu.union(top, p);
            wqu2.union(top, p);
        }

        // bottom row cases, connect to virtual bottom site
        if (row == grid.length - 1) {
            wqu.union(p, bottom);
        }
    }

    public boolean isOpen(int row, int col) {
        outOfBound(row, col);
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        outOfBound(row, col);
        return wqu2.connected(top, xyTo1D(row, col));
    }

    /** If @param row or @param col is out of grid's bound, throw an error. */
    private void outOfBound(int row, int col) {
        int N = grid.length;
        if (row < 0 || row >= N) {
            throw new java.lang.IndexOutOfBoundsException(
                    "row " + row + " is not between 0 and " + (N - 1));
        }
        if (col < 0 || col >= N) {
            throw new java.lang.IndexOutOfBoundsException(
                    "col " + col + " is not between 0 and " + (N - 1));
        }
    }

    private int xyTo1D(int row, int col) {
        return row * grid.length + col;
    }

    public int numberOfOpenSites() {
        return count;
    }

    public boolean percolates() {
        return wqu.connected(top, bottom);
    }

    public static void main(String[] args) {

    }
}
