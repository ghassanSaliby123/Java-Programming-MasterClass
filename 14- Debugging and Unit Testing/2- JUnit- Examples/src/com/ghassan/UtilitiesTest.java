package com.ghassan;

import org.junit.Before;

import static org.junit.Assert.*;

public class UtilitiesTest {
    private Utilities utilities;

    @org.junit.Before
    public void setup(){
        Utilities utilities = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
       // fail("everyNthChar is failed");
        char[] output = utilities.everyNthChar(new char[]{'h','e','l','l','o'},2);
        assertArrayEquals(new char[]{'e','l'}, output);
        char[] output2 = utilities.everyNthChar(new char[]{'h','e','l','l','o'},8);
        assertArrayEquals(new char[]{'h','e','l','l','o'}, output2);
    }

    @org.junit.Test
    public void removePairs() {
       // fail("removePairs is failed");
        assertEquals("ABCDEF",utilities.removePairs("AABBCDDEFF"));
    }

    @org.junit.Test(expected =  ArithmeticException.class)
    public void converter_Exception() throws Exception {
        //    fail("converter is failed");
        utilities.converter(10, 0);

    }

    @org.junit.Test
    public void converter() {
        //    fail("converter is failed");
        assertEquals(300,utilities.converter(10,5));

    }
    @org.junit.Test
    public void nullIfOddLength() {
      //  fail("nullIfOddLength is failed");
        assertNull(utilities.nullIfOddLength("odd"));
        assertNotNull(utilities.nullIfOddLength("even"));
    }
}