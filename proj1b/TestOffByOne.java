import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    // Your tests go here.
    public void testEqualChars() {
        assertFalse(offByOne.equalChars('a', 'c'));
        assertFalse(offByOne.equalChars('c', 'z'));
        assertFalse(offByOne.equalChars('c', 'D'));
        assertFalse(offByOne.equalChars('z', 'z'));

        assertTrue(offByOne.equalChars('d', 'e'));
        assertTrue(offByOne.equalChars('n', 'm'));
        assertTrue(offByOne.equalChars('&', '%'));
    }

}
