import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTestMy {
    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertEquals(0, a.size());
    }

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        assertEquals(2, a.size());
    }

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addLast(1);
        a.addLast(2);
        assertEquals(2, a.size());
    }

    @Test
    public void testResize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addLast(2);
        a.addFirst(3);
        a.addLast(4);
        a.addFirst(5);
        a.addFirst(6);
        a.addFirst(7);
        a.addLast(8);
        a.addLast(9);
        a.addFirst(10);
        assertEquals(10, a.size());

        ArrayDeque<Integer> b = new ArrayDeque<>();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);
        b.addLast(4);
        b.addLast(5);
        b.addLast(6);
        b.addLast(7);
        b.addLast(8);
        b.addLast(9);
        assertEquals(9, b.size());
        b.removeLast();
        b.removeLast();
        b.removeLast();
        b.removeLast();
        b.removeLast();
        b.removeLast();
        b.removeLast();
    }

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertTrue(a.isEmpty());

        a.addFirst(1);
        assertFalse(a.isEmpty());
    }

    @Test
    public void testSize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertEquals(0, a.size());
        a.addFirst(1);
        assertEquals(1, a.size());

    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addLast(2);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.removeFirst()));
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addLast(2);
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(a.removeLast()));
    }

    @Test
    public void testGet() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addLast(1);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.get(0)));
        a.addLast(2);
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(a.get(1)));

        ArrayDeque<Integer> b = new ArrayDeque<>();
        b.addFirst(1);
        b.addLast(2);
        b.addFirst(3);
        b.addLast(4);
        b.addFirst(5);
        b.addFirst(6);
        b.addFirst(7);
        b.addLast(8);
        assertEquals(java.util.Optional.of(7), java.util.Optional.of(b.get(0)));
        assertEquals(java.util.Optional.of(8), java.util.Optional.of(b.get(7)));
    }

    @Test
    public void testMore() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addLast(0);
        a.addLast(1);
        a.addFirst(2);
        a.addLast(3);
        a.removeLast();
        a.removeFirst();
        a.addLast(6);
        a.removeLast();
        a.addFirst(8);
        a.isEmpty();
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.removeLast()));
    }
}
