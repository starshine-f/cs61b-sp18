import static org.junit.Assert.*;
import org.junit.Test;

public class TestFilk {
    @Test
    public void testFilk() {
        assertTrue("something wrong", Flik.isSameNumber(127, 127));
        assertFalse("something wrong", Flik.isSameNumber(128, 128));
    }
}
