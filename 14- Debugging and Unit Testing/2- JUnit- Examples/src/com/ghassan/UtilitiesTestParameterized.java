package com.ghassan;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {

    private Utilities utilities;

    private String input;
    private String output;

    @Before
    public void setUp(){
        utilities = new Utilities();
    }

    public UtilitiesTestParameterized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {"ABCDEFF","ABCDEF"},
                {"AB88EFFG","AB8EFG"},
                {"112233445566", "123456"},
                 {"A","A"}
        });
    }
    @Test
    public void removePairs() throws Exception{
        assertEquals(output,utilities.removePairs(input));
    }
}
