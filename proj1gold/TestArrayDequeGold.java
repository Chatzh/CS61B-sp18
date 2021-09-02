import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    StudentArrayDeque<Integer> stuArray = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> expArray = new ArrayDequeSolution<>();

    @Test
    public void test1000() {
        testN(1000);
    }

    private void testN(int n) {
        String[] operation = new String[n];
        String message = "";

        for (int i = 0; i < n; i++) {
            double randomNumber = StdRandom.uniform();
            Integer stuNumber, expNumber;

            if (randomNumber < 0.2) {
                operation[i] = "addFirst()";
                stuArray.addFirst(i);
                expArray.addFirst(i);
            } else  if (randomNumber < 0.5) {
                operation[i] = "addLast()";
                stuArray.addLast(i);
                expArray.addLast(i);
            } else if (randomNumber < 0.7) {
                operation[i] = "removeFirst()";
                stuNumber = stuArray.removeFirst();
                expNumber = expArray.removeFirst();
                assertEquals(message + operation[i], expNumber, stuNumber);
            } else {
                operation[i] = "removeLast()";
                stuNumber = stuArray.removeLast();
                expNumber = expArray.removeLast();
                assertEquals(message + operation[i], expNumber, stuNumber);
            }

            message += operation[i] + "\n";
        }
    }
}
