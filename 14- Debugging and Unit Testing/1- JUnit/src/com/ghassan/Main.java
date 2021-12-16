package com.ghassan;

public class Main {

    //This code example illustrates the JUnit.Assert package
    //- The test methods should be void and there are various types of assert to check the code
    //- All test methods are annotated with @Test
    //- We can write a code that is running before any test is executed,and we should annotate
    // it with @Before
    //- We can write a code that is running after any test is executed,and we should annotate
    // it with @After
    //- We can write a method that runs once, and we don't want to run it before every test
    //we use the @BeforeClass annotation and the method should be void and static
    //- The same for @AfterClass
    //- We can make the test fail by the fail() method and print a message for failure
    //- If we want to test weather an exception is thrown or not, we can add argument to the @Test
    //as follows @Test(expected = the exception.Class) this arg should be a Class
    //*****************************************************************************************
    //Parameterized test tests allow a developer to run the same test over and
    // over again using different values
    //We annotated the whole test class with @RunWith(Parameterized.class)
    public static void main(String[] args) {
	// write your code here
        System.out.println("Running....");
    }
}
