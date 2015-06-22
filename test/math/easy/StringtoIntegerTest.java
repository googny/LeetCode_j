package math.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author googny
 * @since 2015/6/21
 */
public class StringtoIntegerTest {

    StringtoInteger str2int;

    @Before
    public void setUp() throws Exception {
        str2int = new StringtoInteger();
    }

    @Test
    public void testMyAtoi() throws Exception {
        assertEquals(100, str2int.myAtoi("+100"));
        assertEquals(-100, str2int.myAtoi("   -100"));
        assertEquals(0, str2int.myAtoi("ab+100"));
        assertEquals(0, str2int.myAtoi("+ab100"));
        assertEquals(1, str2int.myAtoi("001"));
        assertEquals(2147483647, str2int.myAtoi("2147483647"));
        assertEquals(-2147483648, str2int.myAtoi("-2147483648"));
        assertEquals(-2147483648, str2int.myAtoi("-2147483649"));
        assertEquals(2147483647, str2int.myAtoi("2147483648"));
        assertEquals(-2147483648, str2int.myAtoi("      -11919730356x"));
    }
}
