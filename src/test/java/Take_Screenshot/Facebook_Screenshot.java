package Take_Screenshot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Library.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Screenshot {
	public static WebDriver driver;
	@Test
	public void facebook_Screenshot() throws IOException, InterruptedException, AWTException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		Thread.sleep(3000);
		driver= new ChromeDriver(options);
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("6302707546");
		Thread.sleep(4000);
		driver.findElement(By.id("pass")).sendKeys("Facebook@143");
		Thread.sleep(4000);
		WebElement Login_Button = driver.findElement(By.name("login"));
		Thread.sleep(4000);
		Login_Button.sendKeys(Keys.TAB);
		Thread.sleep(4000);
		Login_Button.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("kajal agarwal"); 
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()=' photo gallery']/..")).click(); 
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[text()='Photos'])[1]")).click(); 
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='See all']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//img[@alt='No photo description available.,'])[2]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='pmk7jnqg h5g66v2i nezaghv5'])[1]/..")).click(); 
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Photo/video']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='s45kfl79 emlxlaya bkmhp75w spb7xbtv bp9cbjyn rt8b4zig n8ej3o3l agehan2d sk4xxmp2 rq0escxv pq6dq46d taijpn5t l9j0dhe7 tdjehn4e qypqp5cg q676j6op']")).click();
		Thread.sleep(4000);
		StringSelection selection = new  StringSelection("C:\\Users\\Naresh Mannila\\Desktop\\Prince\\Kajal Darling.JPG");
		Thread.sleep(4000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Thread.sleep(4000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(4000);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(4000);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[text()='Post']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//div[@role='button'])[5]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("divya");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(text(),'Divya')])[3]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//div[@class='i09qtzwb n7fi1qx3 b5wmifdl hzruof5a pmk7jnqg j9ispegn kr520xx4 c5ndavph art1omkt ot9fgl3s rnr61an3 s45kfl79 emlxlaya bkmhp75w spb7xbtv'])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='pq6dq46d tbxw36s4 knj5qynh kvgmc6g5 ditlmg2l oygrvhab nvdbi5me sf5mxxl7 orb7ywq3 la0tivve'])[17]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='i09qtzwb n7fi1qx3 hzruof5a pmk7jnqg j9ispegn kr520xx4 art1omkt ot9fgl3s pedkr2u6 akwz6i9j rnr61an3 s45kfl79 emlxlaya bkmhp75w spb7xbtv']")).click();
		Thread.sleep(3000);
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);	
		File destination = new File("./Screenshots/Facebook_Screenshot.png");
		FileUtils.copyFile(source, destination);
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.takes_Screenshot(driver, result.getName());
		}
	}
}
