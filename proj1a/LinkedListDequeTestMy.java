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
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        assertEquals(2, a.size());
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addLast(1);
        a.addLast(2);
        assertEquals(2, a.size());
    }

    @Test
    public void testIsEmpty() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        assertEquals(true, a.isEmpty());

        a.addFirst(1);
        assertEquals(false, a.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        assertEquals(0, a.size());
        a.addFirst(1);
        assertEquals(1, a.size());

    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addFirst(1);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.removeFirst()));
        assertEquals(0, a.size());
    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addLast(1);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.removeLast()));
        assertEquals(0, a.size());
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addLast(1);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.get(0)));
        a.addLast(2);
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(a.get(1)));
    }

    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        a.addLast(1);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(a.getRecursive(0)));
        a.addLast(2);
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(a.getRecursive(1)));
    }

    @Test
    public void testMore() {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
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
