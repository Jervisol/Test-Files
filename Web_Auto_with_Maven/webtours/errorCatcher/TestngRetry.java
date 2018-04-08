package errorCatcher;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestngRetry implements IRetryAnalyzer {
    private static int maxRetryCount = 3;
    private int retryCount = 1;
 
    /*
     *public interface ITestResult
		extends IAttributes, Comparable<ITestResult>
		This class describes the result of a test.      * 
     */
    
    
    public boolean retry(ITestResult result) {
    	System.out.println("if语句");
        if (retryCount <= maxRetryCount) {
        	retryCount++;
            return true;
        }
        return false;
    }
}