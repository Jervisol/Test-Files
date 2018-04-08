package cases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ECS_Auto_01 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe"); 
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.138.130/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEcsAuto() throws Exception {
    driver.get(baseUrl + "/ecshop/");
    WebDriverWait wait = new WebDriverWait(driver, 8);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ECS_MEMBERZONE > a > img")));
    driver.findElement(By.cssSelector("#ECS_MEMBERZONE > a > img")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("jvtest1");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("首页")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='哈苏（HASSELBLAD）哈苏1亿像素中画幅单反数码相机H6D-100c']")));
    driver.findElement(By.xpath("//img[@alt='哈苏（HASSELBLAD）哈苏1亿像素中画幅单反数码相机H6D-100c']")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("number")));
    driver.findElement(By.id("number")).clear();
    driver.findElement(By.id("number")).sendKeys("2");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[7]/div[2]/div[1]/div[2]/form/ul/li[7]/a[1]")));
    driver.findElement(By.xpath("//html/body/div[7]/div[2]/div[1]/div[2]/form/ul/li[7]/a[1]")).click();
//    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.padd > a > img")));
//    driver.findElement(By.cssSelector("li.padd > a > img")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt=\"checkout\"]")));
    driver.findElement(By.cssSelector("img[alt=\"checkout\"]")).click();
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ECS_SURPLUS")));
    driver.findElement(By.id("ECS_SURPLUS")).clear();
    driver.findElement(By.id("ECS_SURPLUS")).sendKeys("100000");
    driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
    String ono=driver.findElement(By.xpath("//html/body/div[7]/div/h6/font")).getText();
    driver.findElement(By.xpath("//html/body/div[1]/div[2]/ul/li[1]/font/font/a[1]")).click();
    driver.findElement(By.xpath("//html/body/div[7]/div[1]/div/div/div/div/a[3]")).click();
    String xp=driver.findElement(By.id("ECS_SURPLUS")).getAttribute("xpath");
//    driver.findElement(By.name("keywords")).sendKeys(xp);
    wait();
//    /html/body/div[6]/div[2]/div[5]/div/div[2]/div[5]/a/img
    
    
//    
//    /html/body/div[7]/div[2]/div/div/div/table/tbody/tr[2]/td[1]/a
//    /html/body/div[7]/div[2]/div/div/div/table/tbody/tr[2]/td[5]/font/a
//    
//    /html/body/div[7]/div[2]/div/div/div/table/tbody/tr[3]/td[1]/a
//    /html/body/div[7]/div[2]/div/div/div/table/tbody/tr[3]/td[5]/font/a
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
