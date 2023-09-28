package web;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PassingTests {

    // 1. Passing Test
    @Test
    public void passingTest1() {
        Assert.assertTrue(true);
    }

    // 2. Passing Test
    @Test
    public void passingTest2() {
        Assert.assertEquals("hello", "hello");
    }

    // 3. Passing Test
    @Test
    public void passingTest3() {
        Assert.assertNotEquals(1, 2);
    }

    // 4. Passing Test
    @Test
    public void passingTest4() {
        Assert.assertNotNull(new Object());
    }

    // 5. Passing Test
    @Test
    public void passingTest5() {
        Assert.assertNull(null);
    }

    // 6. Passing Test
    @Test
    public void passingTest6() {
        Assert.assertTrue(5 > 3);
    }

    // 7. Passing Test
    @Test
    public void passingTest7() {
        Assert.assertFalse(false);
    }

    // 8. Passing Test
    @Test
    public void passingTest8() {
        Assert.assertEquals(3.14159, 3.14159, 0.00001);
    }

    // 9. Passing Test
    @Test
    public void passingTest9() {
        Assert.assertTrue("test".contains("es"));
    }

    // 10. Passing Test
    @Test
    public void passingTest10() {
        Assert.assertNotSame(new Object(), new Object());
    }

    @Test
    public void intermittentTest() {
        System.out.println("Testing Intermittent Test");

        // This test will fail intermittently depending on the state of the system
        int randomNumber = new Random().nextInt(10);
        Assert.assertEquals(randomNumber, 7, "Intermittent test failed");
    }
}
