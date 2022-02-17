package Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Amazon_Utility {
	public static void amazon_Screenshot(WebDriver driver,String amazon_Screenshot) throws IOException
	{
		try
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./Screenshots/"+amazon_Screenshot+".png");
			FileUtils.copyFile(source, destination);
		}
		catch (Exception e) {
			System.out.println("Exception while taking screenshot:"+e.getMessage());
		}
	}
}


