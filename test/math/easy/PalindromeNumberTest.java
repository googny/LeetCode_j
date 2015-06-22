package math.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeNumberTest {

    PalindromeNumber pn;

    @Before
    public void setUp() throws Exception {
        pn = new PalindromeNumber();
    }

    @Test
    public void testIsPalindrome() throws Exception {
        assertEquals(false, pn.isPalindrome(1000));
        assertEquals(true, pn.isPalindrome(1111111));
        assertEquals(true, pn.isPalindrome(100010001));
    }
}