package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class AccountPage extends BasePage{

WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy (xpath="//div[@title='New']")
	WebElement btn_new_account;
	
	@FindBy (xpath="//input[@name='Name']")
	WebElement txt_accountname;
	
	@FindBy (xpath="//button[@name='SaveEdit']")
	WebElement btn_save;
	
	public void click_new_account_button()
	{
		btn_new_account.click();
	}
	
	public void enter_accountname(String aname)
	{
		txt_accountname.sendKeys(aname);
	}
	
	public void click_save_account_button()
	{
		btn_save.click();
	}
	
	
	
	
	
}
