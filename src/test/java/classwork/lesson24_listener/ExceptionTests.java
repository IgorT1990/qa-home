package classwork.lesson24_listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptionTests {

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivision() {
        int a = 5;
        int b = 0;
        Assert.assertEquals(a / b, 0 );
    }
}