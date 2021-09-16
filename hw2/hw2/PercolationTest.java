package hw2;

import static org.junit.Assert.*;
import org.junit.Test;

public class PercolationTest {
    Percolation n = new Percolation(5);

    @Test
    public void testOpen() {
        n.open(0, 0);
        // assertTrue(n.grid[0][0]);
        // assertFalse(n.grid[0][1]);
    }

    @Test
    public void testIsOpen() {
        n.open(0, 0);
        assertTrue(n.isOpen(0, 0));
        assertFalse(n.isOpen(0, 1));
    }

    @Test
    public void testNumberOfOpenSites() {
        assertEquals(0, n.numberOfOpenSites());
        n.open(0, 0);
        assertEquals(1, n.numberOfOpenSites());
        n.open(0, 0);
        assertEquals(1, n.numberOfOpenSites());
        n.open(0, 1);
        assertEquals(2, n.numberOfOpenSites());
    }

    @Test
    public void testIsFull() {
        assertFalse(n.isFull(0, 0));
        n.open(0, 0);
        assertTrue(n.isFull(0, 0));
        assertFalse(n.isFull(1, 0));
        n.open(1, 0);
        assertTrue(n.isFull(1, 0));
        n.open(2, 0);
        n.open(3, 0);
        n.open(4, 0);
        n.open(4, 2);
        assertFalse(n.isFull(4, 2));
    }

    @Test
    public void testPercolates() {
        assertFalse(n.percolates());
        n.open(0, 0);
        n.open(1, 0);
        n.open(2, 0);
        n.open(3, 0);
        assertFalse(n.percolates());
        n.open(4, 0);
        assertTrue(n.percolates());
    }
}
