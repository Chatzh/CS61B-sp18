package hw2;

import edu.princeton.cs.introcs.StdRandom;

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
        double mean = 0;
        for (double x: xt) {
            mean += x;
        }
        return mean / times;
    }

    public double stddev() {
        double mean = mean();
        double stddev = 0;
        for (double x: xt) {
            stddev += (x - mean) * (x - mean);
        }
        return stddev / (times - 1);
    }

    public double confidenceLow() {
        double mean = mean();
        double stddev = stddev();
        double dev = Math.sqrt(stddev);
        return mean - 1.96 * dev / Math.sqrt(times);
    }

    public double confidenceHigh() {
        double mean = mean();
        double stddev = stddev();
        double dev = Math.sqrt(stddev);
        return mean + 1.96 * dev / Math.sqrt(times);
    }
}
