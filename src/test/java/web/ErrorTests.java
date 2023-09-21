package web;

import org.testng.Assert;
import org.testng.annotations.Test;

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
}
