package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	@FindBy(id = "user_email")
	WebElement EmailId;

	@FindBy(id = "user_password")
	WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	
	WebElement BtnLogin;
	
	By forgotPassword = By.xpath("//a[@class='link-below-button']");

	public WebElement getEmail()

	{
		return EmailId;

	}

	public WebElement getPassword()

	{
		return Password;

	}

	public WebElement clickLogin()

	{
		return BtnLogin;

	}
	
	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgotPassword).click();
		ForgotPassword fp= new ForgotPassword(driver);
		return fp;
		
	}

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
}
