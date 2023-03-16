public class OffByN implements CharacterComparator {
    int differ;

    public OffByN(int N) {
        differ = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == differ;
    }

}
