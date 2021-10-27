package hw3.hash;

import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        int N = 0;
        int[] buckets = new int[M];
        for (Oomage o : oomages) {
            int bucketNum = (o.hashCode() & 0x7FFFFFFF) % M;
            N++;
            buckets[bucketNum]++;
        }

        int lowerBound = N / 50;
        int upperBound = (int) (N / 2.5);
        for (int i : buckets) {
            if (i < lowerBound || i > upperBound) {
                return false;
            }
        }

        return true;
    }
}
