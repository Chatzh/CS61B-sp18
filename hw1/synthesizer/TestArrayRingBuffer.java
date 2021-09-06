package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());

        arb.enqueue(0);
        arb.enqueue(2.3d);
        arb.enqueue("null");

        assertEquals(3, arb.fillCount());
        assertEquals(0, arb.dequeue());
        assertEquals(2.3d, arb.dequeue());
        assertEquals("null", arb.peek());
        assertEquals("null", arb.dequeue());
        assertTrue(arb.isEmpty());
        //arb.dequeue();
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
