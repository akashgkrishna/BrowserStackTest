package web;

import org.testng.Assert;
import org.testng.annotations.Test;


public class FailureTests {

    // 1. Simple Assertion Failure Test
    @Test(groups = "sanity")
    public void simpleAssertionFailureTest() {
        Assert.assertTrue(false, "Intentional assertion fail");
    }

    // 2. Expected Exception Not Thrown Test
    @Test(expectedExceptions = ArithmeticException.class, groups = "sanity")
    public void expectedExceptionNotThrownTest() {
        int a = 10;
        int b = 0;
        int c = a / b; // Intentionally not throwing an expected exception
    }

    // 3. Unexpected Exception Thrown Test
    @Test(groups = {"sanity", "regression"})
    public void unexpectedExceptionThrownTest() {
        throw new RuntimeException("Intentional runtime exception");
    }

    // 4. Assertion Failure with Custom Message Test
    @Test(groups = "regression")
    public void assertionFailureWithMessageTest() {
        Assert.assertEquals(1, 2, "Custom assertion failure message");
    }

    // 5. Assertion Failure Without Custom Message Test
    @Test(groups = {"sanity", "regression"})
    public void assertionFailureWithoutMessageTest() {
        Assert.assertEquals("abc", "def");
    }

    // 6. Array Index Out of Bounds Test
    @Test(groups = "regression")
    public void arrayIndexOutOfBoundsTest() {
        int[] arr = {1, 2, 3};
        int element = arr[3]; // Intentional array index out of bounds
    }

    // 7. Null Pointer Exception Test
    @Test(groups = {"sanity", "regression"})
    public void nullPointerExceptionTest() {
        String str = null;
        int length = str.length(); // Intentional null pointer exception
    }

    // 8. Divide by Zero Test
    @Test(groups = "regression")
    public void divisionByZeroTest() {
        int a = 10;
        int b = 0;
        int c = a / b; // Intentional division by zero
    }

    // 9. Assertion Failure with Arrays Test
    @Test(groups = {"sanity", "regression"})
    public void assertionFailureWithArraysTest() {
        int[] expected = {1, 2, 3};
        int[] actual = {4, 5, 6};
        Assert.assertEquals(actual, expected); // Intentional array comparison failure
    }

    // 10. Assertion Failure with Strings Test
    @Test(groups = "regression")
    public void assertionFailureWithStringsTest() {
        Assert.assertEquals("Hello", "World"); // Intentional string comparison failure
    }

    // 11. Assertion Failure with Floating-Point Numbers Test
    @Test(groups = {"sanity", "regression"})
    public void assertionFailureWithFloatingPointTest() {
        double expected = 1.0;
        double actual = 2.0;
        Assert.assertEquals(actual, expected, 0.01); // Intentional floating-point comparison failure
    }

    // 12. Assertion Failure with Collections Test
    @Test(groups = "regression")
    public void assertionFailureWithCollectionsTest() {
        java.util.List<String> expected = java.util.Arrays.asList("apple", "banana");
        java.util.List<String> actual = java.util.Arrays.asList("cherry", "date");
        Assert.assertEquals(actual, expected); // Intentional collection comparison failure
    }

    // 13. Assertion Failure with Boolean Test
    @Test(groups = {"sanity", "regression"})
    public void assertionFailureWithBooleanTest() {
        Assert.assertTrue(false); // Intentional true assertion failure
    }

    // 14. Assertion Failure with Object Identity Test
    @Test(groups = "sanity")
    public void assertionFailureWithObjectIdentityTest() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Assert.assertSame(obj1, obj2); // Intentional object identity assertion failure
    }
}
