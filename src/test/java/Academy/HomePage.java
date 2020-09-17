package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void Init() throws IOException {
		driver = InitilizeDriver();
		log.info("Driver is initilized");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {

		driver.get(prop.getProperty("Url"));
		log.info("Home Page Loaded");
		LandingPage land = new LandingPage(driver);

		
		LoginPage lp=land.getLogin();
		log.info("Login button clicked ");		
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.clickLogin().click();
		log.info(text);
		ForgotPassword fp= lp.forgotPassword();
		fp.getEmail().sendKeys("xyz");
		fp.sendInstruction().click();
		

	}

	@AfterTest
	public void TearDown() {

		driver.close();
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "nonrestricted@test.com";
		data[0][1] = "12345";
		data[0][2] = "Nonrestricted";

		data[1][0] = "restricted@test.com";
		data[1][1] = "12345";
		data[1][2] = "restricted";
		return data;
	}

}
