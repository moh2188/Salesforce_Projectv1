package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class LoginPage extends BasePage{

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='username']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='Login']")
	WebElement btn_login;
	
	@FindBy(xpath="//input[@role='combobox' and @title='Search Setup']")
	WebElement global_search;
	
	public void enter_username(String username)
	{
		txt_username.sendKeys(username);
	}
	
	public void enter_password(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void click_login()
	{
		btn_login.click();
	}	
	
	public boolean check_globalsearch()
	{
		return global_search.isDisplayed();
	}
}
