import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    OffByN offByN = new OffByN(5);

    @Test
    public void testEqualChars() {
        assertFalse(offByN.equalChars('a', 'c'));
        assertFalse(offByN.equalChars('d', 'd'));

        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
    }
}
