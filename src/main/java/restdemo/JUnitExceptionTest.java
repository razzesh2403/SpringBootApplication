package restdemo;

import org.junit.Assert;
import org.junit.Test;

public class JUnitExceptionTest {
	  
    /**
     * Test of speed method, of class JUnit4ExceptionTest.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testSpeed() {
        System.out.println("speed");
        int distance = 0;
        int time = 0;
        SpeedUtils instance = new SpeedUtils();
        int expResult = 0;
        int result = instance.speed(distance, time); //shold throw exception
        Assert.assertEquals(expResult, result);     
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testNoImplementation() {
        System.out.println("speed");
        Double distance = 0.0;
        SpeedUtils instance = new SpeedUtils();
        Double expResult = 0.0;
        Double result = instance.noImplementation(distance); //shold throw exception
        Assert.assertEquals(expResult, result);     
    }
}
