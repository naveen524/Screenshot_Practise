package Take_Screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Library.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Login {
	public static WebDriver driver;
	@Test
	public void Amazon_Screenshot() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		WebElement hellosign_in = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		Thread.sleep(3000);
		Actions action= new Actions(driver);
		action.moveToElement(hellosign_in).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ap_email")).sendKeys("naveenmanneela@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ap_password")).isDisplayed();
		Thread.sleep(3000);
		driver.findElement(By.id("ap_password")).sendKeys("Amazon@1234");
		Thread.sleep(3000);
		driver.findElement(By.name("rememberMe")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shoes for men");
		Thread.sleep(3000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//img[@class='s-image'])[16]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='a-button-text a-declarative'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("native_dropdown_selected_size_name_12")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("submit.addToCart")).click();
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshot/amazon_Screenshot.png");
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