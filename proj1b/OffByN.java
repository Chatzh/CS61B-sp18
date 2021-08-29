public class OffByN implements CharacterComparator {
    private int shift;

    public OffByN(int i) {
        shift = i;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return diff == shift || diff == -shift;
    }
}
