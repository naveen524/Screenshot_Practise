package Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Flipkart_Utility {
public static void takes_Screenshot(WebDriver driver,String Screenshot_Name) throws IOException
{
	try {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destination = new File("./Screenshots/"+Screenshot_Name+".png");
	FileUtils.copyFile(source, destination);
	System.out.println("screenshot taken:");
	}
	catch(Exception e){
		System.out.println("Exception while taking screenshot:"+e.getMessage());	
	}
	driver.close();
}
}