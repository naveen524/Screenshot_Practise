package Library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Bank_Utility {

	public static void bank_Screenshot(WebDriver driver,String screenshot_Name)
	{
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Screenshots/"+screenshot_Name+".png");
			FileUtils.copyFile(source, destination);
			System.out.println("screenshot taken");
			
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: "+e.getMessage());
		}
	}
}

