public class ForMaxNumber {
    /** Returns the maximum value from m using a for loop. */
    public static int forMax(int[] m) {
        int max_number = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > max_number) {
                max_number = m[i];
            }
        }
        return max_number;
    }
    
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(forMax(numbers));
    }
}