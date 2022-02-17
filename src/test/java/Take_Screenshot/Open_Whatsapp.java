package Take_Screenshot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_Whatsapp {

	public static void main(String[] args) throws AWTException, InterruptedException, FileNotFoundException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_WINDOWS);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_E);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_WINDOWS);
		Thread.sleep(2000);
		r.keyRelease(KeyEvent.VK_E);
		Thread.sleep(2000);
		FileInputStream fis= new FileInputStream("C:/Users/Naresh Mannila/Downloads/WhatsAppSetup (3).exe");
		
		
//		StringSelection selection = new StringSelection("C:\\Users\\Naresh Mannila\\Downloads");
//		Thread.sleep(3000);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//		Thread.sleep(3000);



	}
}
