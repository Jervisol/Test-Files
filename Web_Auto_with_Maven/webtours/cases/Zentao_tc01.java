package cases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Zentao_tc01 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe"); 
    driver = new FirefoxDriver();
    baseUrl = "http://127.0.0.1/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testZtao() throws Exception {
    driver.get(baseUrl + "/zentao.php");
    driver.findElement(By.id("zentao")).click();
    driver.findElement(By.linkText("统计")).click();
    driver.findElement(By.linkText("后台")).click();
    driver.findElement(By.linkText("测试")).click();
    driver.findElement(By.id("searchQuery")).click();
    driver.findElement(By.id("searchQuery")).clear();
    driver.findElement(By.id("searchQuery")).sendKeys("67");
    driver.findElement(By.linkText("GO!")).click();
    driver.findElement(By.id("searchQuery")).click();
    driver.findElement(By.id("searchQuery")).clear();
    driver.findElement(By.id("searchQuery")).sendKeys("66");
    driver.findElement(By.linkText("GO!")).click();
    driver.findElement(By.cssSelector("i.icon-common-edit.icon-pencil")).click();
    driver.findElement(By.cssSelector("button.btn.btn-default")).click();
  }

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
