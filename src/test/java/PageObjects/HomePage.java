package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='profileTrigger branding-user-profile bgimg slds-avatar slds-avatar_profile-image-small circular forceEntityIcon']//span[@class='uiImage']")
	WebElement dropdown_profile;
	
	@FindBy(xpath="//a[normalize-space()='Log Out']")
	WebElement link_logout;
	
	@FindBy (xpath="//div[@class='slds-icon-waffle']")
	WebElement btn_applauncher;
	
	@FindBy (xpath="//input[@class='slds-input' and @type='search']")
	WebElement txt_applauncher_search;
	
	@FindBy (xpath="//*[@class='al-menu-dropdown-list' and @role='listbox']")
	List<WebElement> res_applauncher;
	
	@FindBy (xpath="//button[@aria-label='Search' and @type='button']")
	WebElement element_enable_globalsearch;
	
	@FindBy (xpath="//input[@class='slds-input' and @id='input-125']")
	WebElement enter_value_globalsearch;
	
	@FindBy (xpath="//input[@type='text' and @role='combobox']")
	WebElement btn_globalsearch_dropdown;
	
	@FindBy (xpath="//div[@id='dropdown-element-122']//ul//li")
	List<WebElement> val_globalsearch_dropdown;
	
	@FindBy (xpath="//div[@role='option']//div[2]//span//child::span")
	List<WebElement> select_globalsearch_option;
	
	@FindBy (xpath="//lightning-formatted-text[@slot='primaryField']")
	WebElement conf_account;
	
	
	public void click_profile()
	{
		dropdown_profile.click();
	}
	
	public void click_logout()
	{
		link_logout.click();
	}
	
	public void click_applauncher()
	{
		btn_applauncher.click();
	}
	
	public void txt_applauncher_search(String txt)
	{
		txt_applauncher_search.click();
		txt_applauncher_search.sendKeys(txt);
	}
	
	public void res_app(String res)
	{
		for(WebElement x:res_applauncher )
		{
			
			if(x.getText().equalsIgnoreCase(res))
			{
				x.click();
			}
		}
	}
	
	public void click_globalsearch()
	{
		element_enable_globalsearch.click();
	}
	
	
	public void enter_text_globalsearch(String sval)
	{
		
		enter_value_globalsearch.sendKeys(sval);
	}
	
	public void click_globalsearch_dropdown()
	{
		btn_globalsearch_dropdown.click();
	}
	
	public void select_globalsearch_dropdown()
	{
		for(WebElement x: val_globalsearch_dropdown )
		{
			
			if(x.getText().equals("Accounts"))
			{
				x.click();
			}
		}
	}
	
	public void select_globalsearch_option(String goption)
	{
		for(WebElement x: select_globalsearch_option )
		{
			
			if(x.getText().equals(goption))
			{
				x.click();
			}
		}
	}
	
	public String conf_account()
	{
		return conf_account.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
}
