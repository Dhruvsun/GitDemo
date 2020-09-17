package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver InitilizeDriver() throws IOException {
		String path = System.getProperty("user.dir");
		String propertyPath = path + "\\src\\main\\java\\resources\\data.properties";
		prop = new Properties();
		FileInputStream fis = new FileInputStream(propertyPath);
		prop.load(fis);
		
		//String browserName=System.getProperty("browser") //FOR Maven 
		String browserName = prop.getProperty("browser"); //form normal execution 

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();	
			
			 if(browserName.contains("headless"))
			 {
				 option.addArguments("headless");
			 }
			driver = new ChromeDriver();
			
			
		} 
		else if (browserName.equals("firefox")) {
			// gerico browser set
			System.setProperty("webdriver.gecko.driver", path+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			// gerico browser set
			System.setProperty("webdriver.ie.driver", "C://IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;

	}
}
