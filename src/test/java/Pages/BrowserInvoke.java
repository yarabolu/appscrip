package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BrowserInvoke {

	
	@Test
	public static void browser() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();  // Automatically handles the driver
		
		  WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        
     WebElement Expectedresult  =   driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
     Expectedresult.sendKeys("OpenAI");
            Thread.sleep(1000);
            List<WebElement> li = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
            for (int i = 0; i <li.size(); i++) {
            	if (li.get(i).getText().contains("OpenAI")) {
					System.out.println("result contains the word");
					break;
				}else {
					System.out.println("first result not contains the word");
         		}
			}
          Thread.sleep(2000);
          

          File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

          // Generate timestamped filename
          String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
          String screenshotFile = "screenshots/screenshot" + timestamp + ".png";
         // File destFile = new File(screenshotFile);
          File destFile = new File("" + screenshotFile);
          // Save the screenshot to project root
          Files.copy(srcScreenshot.toPath(), destFile.toPath());

          System.out.println("📸 Screenshot saved: " + destFile.getAbsolutePath());
          

	}


}