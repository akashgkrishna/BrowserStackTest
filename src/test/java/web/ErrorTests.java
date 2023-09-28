package web;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ErrorTests {

    @Test
    public void divisionByZeroTest() {
        System.out.println("Testing Division by Zero Error");

        // Runtime ArithmeticException (division by zero)
        int a = 10;
        int b = 0;
        int c = a / b;

        System.out.println(c);
    }

    @Test
    public void intentionalAssertionFailureTest() {
        System.out.println("Testing Intentional Assertion Failure");

        // Intentional assertion fail
        Assert.assertEquals(2, 1, "Intentional assertion fail");
    }

    @Test
    public void flakyTest1() throws InterruptedException {
        System.out.println("Testing Flaky Test");

        // This test will fail intermittently depending on the state of the system
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000); // Sleep for 1 second
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        Assert.assertTrue(elapsedTime >= 1000, "Flaky test failed"); // Check if the elapsed time is at least 1000 ms
    }

    // This test is flaky because it relies on the output of a random number generator
    @Test
    public void intermittentTest() {
        System.out.println("Testing Intermittent Test");

        // This test will fail intermittently depending on the state of the system
        int randomNumber = new Random().nextInt(10);
        Assert.assertTrue(randomNumber == 5, "Intermittent test failed");
    }
}
