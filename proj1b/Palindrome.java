public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> wordDeque = new LinkedListDeque<>();
        for (char c : word.toCharArray()) {
            wordDeque.addLast(c);
        }
        return wordDeque;
    }

    public boolean isPalindrome(String word) {
        Deque wordDeque = wordToDeque(word);
        return isPalindromeHelper(wordDeque);
    }

    /** A helper function of isPalindrome. */
    private boolean isPalindromeHelper(Deque d) {
        if (d.size() <= 1) {
            return true;
        }
        Character first = (char) d.removeFirst(),
                  last = (char) d.removeLast();
        return first.equals(last) && isPalindromeHelper(d);
    }
}
