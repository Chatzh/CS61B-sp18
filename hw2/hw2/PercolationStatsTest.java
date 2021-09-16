package hw2;

import org.junit.Test;

public class PercolationStatsTest {
    PercolationStats p = new PercolationStats(20, 1000, new PercolationFactory());

    @Test
    public void test() {
        System.out.println("mean: " + p.mean());
        System.out.println("standard deviation: " + p.stddev());
        System.out.println("confidence low: " + p.confidenceLow());
        System.out.println("confidence high: " + p.confidenceHigh());
    }
}
