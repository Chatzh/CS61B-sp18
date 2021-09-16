package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private double[] xt;
    private int times;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException("N or T is less than 1");
        }

        times = T;
        xt = new double[times];
        for (int i = 0; i < times; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                p.open(row, col);
            }
            xt[i] = p.numberOfOpenSites() / (double) (N * N);
        }
    }

    public double mean() {
        return StdStats.mean(xt);
    }
    public double stddev() {
        return StdStats.stddev(xt);
    }
    public double confidenceLow() {
        return mean() - 1.96 * Math.sqrt(stddev() / times);
    }
    public double confidenceHigh() {
        return mean() + 1.96 * Math.sqrt(stddev() / times);
    }
}
