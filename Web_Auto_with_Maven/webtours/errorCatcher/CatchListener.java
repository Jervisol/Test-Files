package errorCatcher;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import base.WebBase;

public class CatchListener extends TestListenerAdapter {
	//监听，当被监听的测试类执行失败，就来执行如下代码，这些类都是testNg框架里面的类。
  @Override
  public void onTestFailure(ITestResult tr) {
	  super.onTestFailure(tr);
	  takeScreenShot(tr);
}
  private void takeScreenShot(ITestResult tr){
	  
	//生成时间
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	  String mDateTime = formatter.format(new Date());
	  
	  //生成测试类对象，driver在哪个类里面定义的，就用哪个类来生成对象
	  WebBase wbase = new WebBase();
	  
	  //将测试类的driver赋值给当前类的driver，意味着，这个监听类和测试类用的driver是同一个，保持一致，不一致就会出错
	  WebDriver driver = wbase.getWebDriver();
	  
	  //生成一个file类的对象，用来在磁盘上创建文件
	  File location = new File("Fails");
	  
	  //对截取的图片进行重命名，命名成路径+时间+执行的测试用例名+格式
	  String picName = location.getAbsolutePath()+mDateTime+File.separator+tr.getMethod().getMethodName()+".png";
	  //截屏
	  
	  //这段代码是得到保存错误图片的路径，并转换成cmd命令执行的格式
	  String a = location.getAbsolutePath()+mDateTime+File.separator;  
	  
	  String s = a.replaceAll("\\\\", "/");//   \\\\   
	  
	  s = s.substring(0, s.length()-1);		  
	  
	  System.out.println(s);
	  
	  
	  File Fails = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  try{
	  //把截屏图片拷贝到指定路径
		  FileUtils.copyFile(Fails, new File(picName));
		  /*
		   * 这段代码就是在执行自动化的过程中调用cmd命令行
		   * public void excuteAdbShell(String string) {
			Runtime runtime=Runtime.getRuntime();
	        try{
	            runtime.exec(string);
	        }catch(Exception e){
	            System.out.print("执行命令:"+string+"出错");
	        }			
			}	
		   * 
		   
		  tb.AdbRun("adb pull /mnt/sdcard/log/system.log "+s );*/
	  }catch(IOException E){
		  E.printStackTrace();
	  }	  
  }
  
}