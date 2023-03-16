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
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("house"));

        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testIspalindrome_new() {
        OffByOne offByOne = new OffByOne();
        assertFalse(palindrome.isPalindrome("aba", offByOne));
        assertTrue(palindrome.isPalindrome("abb", offByOne));

        OffByN offByN = new OffByN(3);
        assertFalse(palindrome.isPalindrome("aaa", offByN));
        assertTrue(palindrome.isPalindrome("abzed", offByN));
    }
    
}
