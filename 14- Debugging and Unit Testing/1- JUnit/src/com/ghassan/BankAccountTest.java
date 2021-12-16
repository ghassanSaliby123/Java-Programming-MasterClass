package com.ghassan;

import org.junit.*;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount bankAccount;
    private static int count;

    //Run once before the tests
    @BeforeClass
    public static void beforeClass(){
        System.out.println("This executes once before any tests. Count = " + count++);
    }
    //Run before every test
    @Before
    public void setUp(){
        bankAccount = new BankAccount("Ghassan", "Saliby", 1000, BankAccount.CHECKING);
        System.out.println("Running a test....");
    }

    @org.junit.Test
    public void deposit() throws Exception {
        //fail("This test has yet to be implemented");
        double balance = bankAccount.deposit(200, true);
        assertEquals(1200, balance, 0);
        assertEquals(1200, bankAccount.getBalance(), 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
//        fail("This test has yet to be implemented");
        double balance = bankAccount.withdraw(600, true);
        assertEquals(400, balance, 0);
    }

    //Test if there is a thrown exception
    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch(){
         bankAccount.withdraw(600, false);
    }

    @org.junit.Test
    public void getBalance_deposit() throws Exception {
//        fail("This test has yet to be implemented");
        bankAccount.deposit(200, true);
        assertEquals(1200, bankAccount.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() throws Exception {
//        fail("This test has yet to be implemented");
        bankAccount.withdraw(200, true);
        assertEquals(800, bankAccount.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking() throws Exception {
//        fail("This test has yet to be implemented");
        assertTrue("The account is not a checking account", bankAccount.isChecking());
    }

    //Runs once after all tests
    @AfterClass
    public static void afterClass(){
        System.out.println("This is executed once after all tests. Count = "+ count++);
    }

    //Runs after every test
    @After
    public void tearDown(){
        System.out.println("Count = "+ count++);
    }
}

