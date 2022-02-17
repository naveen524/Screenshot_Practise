package Take_Screenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Library.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Fund_Transfer {
	public static WebDriver driver;
	//public static void main(String[] args) throws IOException, InterruptedException {
	@Test
	public void takes_Screenshot() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://demo.guru99.com/v4/index.php");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("uid")).sendKeys("mngr377966");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("Gurubank@143");
		Thread.sleep(2000);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Fund Transfer']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Fund Transfer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("payersaccount")).sendKeys("1234");
		Thread.sleep(3000);
		driver.findElement(By.name("payeeaccount")).sendKeys("123456");
		Thread.sleep(3000);
		driver.findElement(By.name("ammount")).sendKeys("500");
		Thread.sleep(3000);
		driver.findElement(By.name("desc")).sendKeys("personal Transaction");
		Thread.sleep(3000);
		driver.findElement(By.name("AccSubmit")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots/screenshot.png");
		FileUtils.copyFile(source, destination);
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.takes_Screenshot(driver, result.getName());
		}
		driver.close();
		
	}
}
