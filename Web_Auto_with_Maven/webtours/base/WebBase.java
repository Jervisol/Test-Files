package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebBase {
	public static WebDriver driver;
	public String baseUrl;
	public boolean acceptNextAlert = true;
	public StringBuffer verificationErrors = new StringBuffer();
	
	public static WebDriver getWebDriver(){
		return driver;
	}
  
  @Parameters(value={"browserType","driverPath"})
  @BeforeClass(alwaysRun = true)
  public void setUp(String browserType, String driverPath) throws Exception {
//	System.setProperty("webdriver.gecko.driver", "D:/Repository_Var/webdriver/geckodriver.exe"); 
    driver = null;
    if("chrome".equalsIgnoreCase(browserType)){
    	System.setProperty("webdriver.chrome.driver",driverPath);
    	driver = new ChromeDriver();
    }else if("firefox".equalsIgnoreCase(browserType)){
    	System.setProperty("webdriver.gecko.driver",driverPath);
    	driver = new FirefoxDriver();
    }
    
    baseUrl = "http://127.0.0.1:1080/";
//    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  } 
  
  @Ignore
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
