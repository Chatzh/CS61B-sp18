package hw2;

import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {
    private double mean;
    private double stddev;
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
        mean = 0;
        for (double x: xt) {
            mean += x;
        }
        mean /= times;
        return mean;
    }

    public double stddev() {
        mean();
        stddev = 0;
        for (double x: xt) {
            stddev += (x - mean) * (x - mean);
        }
        stddev /= (times - 1);
        return stddev;
    }

    public double confidenceLow() {
        stddev();
        double dev = Math.sqrt(stddev);
        return mean - 1.96 * dev / Math.sqrt(times);
    }

    public double confidenceHigh() {
        stddev();
        double dev = Math.sqrt(stddev);
        return mean + 1.96 * dev / Math.sqrt(times);
    }
}
