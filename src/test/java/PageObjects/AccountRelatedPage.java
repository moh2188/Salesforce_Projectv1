package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class AccountRelatedPage extends BasePage{

	public AccountRelatedPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// upload file in notes and attachment of account
	@FindBy (xpath="//input[@type='file' and @part='input']")
	WebElement account_file;
	
	public WebElement account_fileUpload()
	{
		return account_file;
	}
	
	
}
