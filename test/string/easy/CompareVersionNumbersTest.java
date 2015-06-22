package string.easy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompareVersionNumbersTest {

    CompareVersionNumbers cvn;

    @Before
    public void setUp() throws Exception {
        cvn = new CompareVersionNumbers();
    }

    @Test
    public void testCompareVersion() throws Exception {
        assertEquals(-1, cvn.compareVersion("0.1", "10.01"));
        assertEquals(0, cvn.compareVersion("0.1", "0.01"));
        assertEquals(0, cvn.compareVersion("0.11", "0.011"));
        assertEquals(1, cvn.compareVersion("1.1", "1.0"));
        assertEquals(-1, cvn.compareVersion("1.1", "1.1.1"));
        assertEquals(-1, cvn.compareVersion("1", "1.00.01"));
        assertEquals(1, cvn.compareVersion("1.1", "1.0.1"));
    }
}