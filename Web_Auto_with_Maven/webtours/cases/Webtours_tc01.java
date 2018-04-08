package cases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.webtours.util.DataUtil;

import base.WebBase;

public class Webtours_tc01 extends WebBase{
	@Test(dataProvider="loginfo")
	public void testLhz(String id, String pwd, String tip) throws Exception {
	    driver.get(baseUrl + "/WebTours");
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).sendKeys(id);
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).sendKeys(pwd);
	    driver.findElement(By.xpath("/html/body/form/table/tbody/tr[9]/td[2]/input")).click();
	    WebElement tips = driver.findElement(By.name("//*[contains(text(),'"+tip+"']"));
	    Assert.assertNotNull(tips, "wrong tips");
	}
	
	
	@DataProvider
	public Object[][] loginfo() throws Exception{
		Object[][] data = DataUtil.read("/LogInfo.xlsx",2,4,1,3);
		return data;
	}
	@Ignore
	public void logintest() throws Exception{
		driver.get(baseUrl + "/WebTours");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Web Tours", "Title is wrong!");
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("SoftwareTestingMaterial.com");
//		WebElement exptext = driver.findElement(By.xpath("//*[contains(text(),'expect text')]"));
//		Assert.assertNotNull(exptext);	
	}
}
