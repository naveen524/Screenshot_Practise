package Library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void takes_Screenshot(WebDriver driver,String screenshotName)
	{

		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Screenshot/"+screenshotName+".png");
			FileUtils.copyFile(source, destination);
			Thread.sleep(2000);
			System.out.println("screenshot taken");
		} 
		catch (Exception e) 
		{
			System.out.println("Exception while taking screenshot:"+e.getMessage());	
		}
	}
}

