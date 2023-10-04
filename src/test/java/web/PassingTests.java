package web;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PassingTests {

    // 1. Passing Test
    @Test(groups = {"regression"})
    public void passingTest1() {
        Assert.assertTrue(true);
    }

    // 2. Passing Test
    @Test(groups = {"sanity", "regression"})
    public void passingTest2() {
        Assert.assertEquals("hello", "hello");
    }

    // 3. Passing Test
    @Test(groups = {"sanity", "regression"})
    public void passingTest3() {
        Assert.assertNotEquals(1, 2);
    }

    // 4. Passing Test
    @Test(groups = {"regression"})
    public void passingTest4() {
        Assert.assertNotNull(new Object());
    }

    // 5. Passing Test
    @Test(groups = {"regression"})
    public void passingTest5() {
        Assert.assertNull(null);
    }

    // 6. Passing Test
    @Test(groups = {"regression"})
    public void passingTest6() {
        Assert.assertTrue(5 > 3);
    }

    // 7. Passing Test
    @Test(groups = {"regression"})
    public void passingTest7() {
        Assert.assertFalse(true);
    }

    // 8. Passing Test
    @Test(groups = {"regression"})
    public void passingTest8() {
        Assert.assertEquals(3.14159, 3.14159, 0.00001);
    }

    // 9. Passing Test
    @Test(groups = {"sanity", "regression"})
    public void passingTest9() {
        Assert.assertTrue("test".contains("es"));
    }

    // 10. Passing Test
    @Test(groups = {"sanity", "regression"})
    public void passingTest10() {
        Assert.assertNotSame(new Object(), new Object());
    }

    @Test(groups = {"sanity", "regression"})
    public void intermittentTestFromPassClass() {
        System.out.println("Testing Intermittent Test");

        int randomNumber = new Random().nextInt(2);
        Assert.assertEquals(randomNumber, 1, "Intermittent test failed");
    }

    @Test(groups = {"sanity", "regression"})
    public void flakyTestFromPassClass() throws InterruptedException {
        System.out.println("Testing Flaky Test");

        // This test will fail intermittently depending on the state of the system
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000); // Sleep for 1 second
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        Assert.assertTrue(elapsedTime >= 1000, "Flaky test failed"); // Check if the elapsed time is at least 1000 ms
    }
}
