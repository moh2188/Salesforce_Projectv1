package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class EditAccountPage extends BasePage{

	WebDriver driver;
	
	public EditAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy (xpath="//lightning-button-menu[@class='menu-button-item slds-dropdown-trigger slds-dropdown-trigger_click']//button[@type='button']")
	WebElement click_AccDropdown;
	
	@FindBy (xpath="//div[@class='slds-dropdown__item' and @part='menu-item']//a//span")
	List<WebElement> select_edit_options;
	
	@FindBy (xpath="//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value' and @aria-label='Rating']")
	WebElement select_rating;
	
	@FindBy (xpath="//*[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain']")
	List<WebElement> rating_options;
	
	@FindBy (xpath="//button[@name='SaveEdit']")
	WebElement btn_editsave;
	
	public void click_account_dropdown()
	{
		click_AccDropdown.click();
	}
	
	public void click_account_edit(String acct_option)
	{
		for(WebElement x:select_edit_options)
		{
			
			if(x.getText().equals("acct_option"))
			{
				x.click();
			}
		}
	}
	
	public void click_rating()
	{
		select_rating.click();
		
	}
	
	public void select_rating(String ops)
	{
		for(WebElement x:rating_options)
		{
			//System.out.println(x.getText());
			if(x.getText().equals(ops))
			{
				x.click();
			}
		}
	}
	
	public void click_editSave()
	{
		btn_editsave.click();
	}
		
	
}
