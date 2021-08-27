import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListDequeTestMy {
    @Test
    public void testLinkedListDeque() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        assertEquals(0, a.size());
    }

    @Test
    public void testAddFirst() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>(1);
        a.addFirst(2);
        assertEquals(2, a.size());
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>(1);
        a.addLast(2);
        assertEquals(2, a.size());
    }

    @Test
    public void testIsEmpty() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        LinkedListDeque<Integer> b = new LinkedListDeque<>(1);
        assertEquals(true, a.isEmpty());
        assertEquals(false, b.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        LinkedListDeque<Integer> b = new LinkedListDeque<>(1);
        assertEquals(0, a.size());
        a.addFirst(1);
        assertEquals(1, a.size());

        assertEquals(1, b.size());
        b.addLast(2);
        assertEquals(2, b.size());
    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>(2);
        a.addFirst(1);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.removeFirst()));
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(a.removeFirst()));
        assertEquals(0, a.size());
    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>(1);
        a.addLast(2);
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(a.removeLast()));
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.removeLast()));
        assertEquals(0, a.size());
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>(1);
        a.addLast(2);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.get(0)));
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(a.get(1)));
    }
}