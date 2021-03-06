import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("A"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("madam"));
        assertTrue(palindrome.isPalindrome("madamadam"));

        OffByN offByN = new OffByN(1);
        assertTrue(palindrome.isPalindrome("", offByN));
        assertTrue(palindrome.isPalindrome("a", offByN));
        assertTrue(palindrome.isPalindrome("flake", offByN));
        assertTrue(palindrome.isPalindrome("fLaKe", offByN));
        assertTrue(palindrome.isPalindrome("&a%", offByN));
    }
}
