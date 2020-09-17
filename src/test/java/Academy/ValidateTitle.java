package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import pageObjects.LandingPage;

import resources.Base;

public class ValidateTitle extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void Init() throws IOException {
		driver = InitilizeDriver();
		driver.get(prop.getProperty("Url"));
	}

	@Test
	public void ValidatepageTitle() throws IOException {

		LandingPage land = new LandingPage(driver);
		Assert.assertEquals(land.getTitle().getText(), "FEATURED COURSES1");
		Assert.assertTrue(land.getNavbar().isDisplayed());
		log.info("Text is valideated ");

	}

	@AfterTest
	public void TearDown() {

		driver.close();
	}

}
