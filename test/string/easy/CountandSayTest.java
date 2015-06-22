package string.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountandSayTest {
    CountandSay cas;

    @Before
    public void setUp() throws Exception {
        cas = new CountandSay();
    }

    @Test
    public void testCountAndSay() throws Exception {
        assertEquals("1", cas.countAndSay(1));
        assertEquals("11", cas.countAndSay(2));
        assertEquals("21", cas.countAndSay(3));
        assertEquals("1211", cas.countAndSay(4));
        assertEquals("111221", cas.countAndSay(5));
    }
}