import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(3);

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('h', 'e'));
        assertFalse(offByN.equalChars('a', 'c'));
    }
}
