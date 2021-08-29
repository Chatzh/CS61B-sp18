public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return diff == 1 || diff == -1;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome p = new Palindrome();
        Deque<Character> wordDeque = p.wordToDeque(word);
        return isPalindromeHelper(wordDeque, cc);
    }

    /** A helper function of isPalindrome. */
    private boolean isPalindromeHelper(Deque d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }
        char first = (char) d.removeFirst(),
             last = (char) d.removeLast();
        return cc.equalChars(first, last) && isPalindromeHelper(d, cc);
    }
}
