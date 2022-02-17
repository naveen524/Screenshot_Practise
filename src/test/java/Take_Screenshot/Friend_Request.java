package Take_Screenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Friend_Request {
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
		driver.findElement(By.xpath("(//div[@role='button'])[5]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Chandana Katta");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"katta chandana\"]/div/a/div/div[2]/span/span/span[4]")).click();
		//driver.findElement(By.xpath("(//span[contains(text(),' chandana')]/..)[1]")).click();
		//Thread.sleep(6000);
	}
}