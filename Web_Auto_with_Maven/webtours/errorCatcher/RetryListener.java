package errorCatcher;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

	/*
	 * void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod)
		This method will be invoked by TestNG to give you a chance to modify a TestNG annotation read from your test classes. You can change the values you need by calling any of the setters on the ITest interface. Note that only one of the three parameters testClass, testConstructor and testMethod will be non-null.
		Parameters:
		annotation - The annotation that was read from your test class.
		testClass - If the annotation was found on a class, this parameter represents this class (null otherwise).
		testConstructor - If the annotation was found on a constructor, this parameter represents this constructor (null otherwise).
		testMethod - If the annotation was found on a method, this parameter represents this method (null otherwise).

 */

public class RetryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation annotation, Class testClass,
            Constructor testConstructor, Method testMethod) {
    	System.out.println("if之前RetryListener");    	
    	
    	/*public interface IRetryAnalyzer
    	 *Interface to implement to be able to have a chance to retry a failed test. 
    	 * 
    	 * boolean retry(ITestResult result)
			Returns true if the test method has to be retried, false otherwise.
			Parameters:
			result - The result of the test method that just ran.
			Returns:
			true if the test method has to be retried, false otherwise.
    	 * 
    	 */
    	
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
        	System.out.println("加载TestngRetry类之前");
            annotation.setRetryAnalyzer(TestngRetry.class);
            System.out.println("加载TestngRetry类之后");
        }
    }
}
