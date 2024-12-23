package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class AccountApprovalPage extends BasePage{

	public AccountApprovalPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath="//div[@class='slds-dropdown__item' and @part='menu-item']//a//span")
	List<WebElement> select_app_option;

	@FindBy (xpath="//textarea[@role='textbox']")
	WebElement text_appcomment;
	
	@FindBy (xpath="//span[normalize-space()='Submit']")
	WebElement btn_submit;
	
	@FindBy (xpath="//flexipage-tab2[@id='tab-8']//a[contains(@title,'Approve')]")
	WebElement btn_approve1;
	
	@FindBy (xpath="//span[normalize-space()='Approve']")
	WebElement btn_approve2;
	
	public void click_account_approval(String acct_option)
	{
	
		for(WebElement x:select_app_option)
		{
			if(x.getText().equals("Submit for Approval"))
			{
				x.click();
				
			}
			
		}
		
	}
	
	public void enter_appcomment()
	{
		text_appcomment.sendKeys("approval");
	}
	
	public void click_submitapp()
	{
		btn_submit.click();
	}
	
	public void click_approve1()
	{
		btn_approve1.click();
	}
	
	public void click_approve2()
	{
		btn_approve2.click();
	}
	
	
	
}
