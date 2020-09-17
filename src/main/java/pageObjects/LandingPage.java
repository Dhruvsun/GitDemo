package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	WebElement login;
	@FindBy(xpath = "//h2[text()='Featured Courses']")
	WebElement title;
	@FindBy(xpath = "//ul[@class='nav navbar-nav navbar-right']") // button[contains(text(),'NO THANKS')]
	WebElement navbar;
	@FindBy(xpath = "//button[contains(text(),'NO THANKS')]")
	WebElement thanksBtn;

	public LoginPage getLogin()

	{
		 login.click();
		 LoginPage lp= new LoginPage(driver);
		 return lp;

	}

	public WebElement getTitle()

	{
		return title;

	}

	public WebElement getNavbar()

	{
		return navbar;

	}

	public WebElement ClickThanks()

	{
		return thanksBtn;

	}

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
}
