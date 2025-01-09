package PageObjects;

import java.util.List;

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
	
	@FindBy (xpath="//button[contains(@title,'List View Controls')]")
	WebElement btn_listview;
	
	@FindBy (xpath="//div[@class='slds-dropdown slds-dropdown_right']//ul//li//span")
	List<WebElement> options_listview;
	
	@FindBy (xpath="//input[@class='slds-input' and @name='title']")
	WebElement txt_listview_name;
	
	@FindBy (xpath="//input[@class='slds-input' and @name='developerName']")
	WebElement txt_listview_name_api;
	
	@FindBy (xpath="//button[@class='slds-button slds-button_neutral test-confirmButton uiButton--default uiButton--brand uiButton']")
	WebElement btn_listview_save;
	
	@FindBy (xpath="//div[@class='slds-dueling-list']//div[3]//ul//li//span")
	List<WebElement> select_available_columns;
	
	@FindBy (xpath="//button[@title='Move to Visible Fields']")
	WebElement moveto_displaycolumn;
	
	@FindBy (xpath="//div[@class='slds-dueling-list']//div[5]//ul//li//span")
	List<WebElement> select_display_column;
	
	@FindBy (xpath="//button[@title='Move selection up']")
	WebElement moveup_displaycolumn;
	
	@FindBy (xpath="//button[@class='slds-button slds-button_neutral test-confirmButton uiButton--default uiButton--brand uiButton']")
	WebElement btn_saveListView;
	
	@FindBy (xpath="//button[@class='slds-button slds-button_neutral test-confirmButton uiButton--default uiButton--brand uiButton']")
	WebElement btn_lv_delete;
	
	
	public void click_button_listviewdelete()
	{
		btn_lv_delete.click();
	}
	
	
	public void click_saveListViewUpdate()
	{
		btn_saveListView.click();
	}
	
	public void moveup_displaycolumn() throws InterruptedException
	{
		int k=select_display_column.size();
		
		for(int i=k;i>=1;i--)
		{
			moveup_displaycolumn.click();
		}
	}
	
	public void select_ColumnfromDisplay()
	{
		for(WebElement x:select_display_column)
		{
			if(x.getText().equals("Active"))
			{
				x.click();
				break;
			}
		}
	}
	
	public void move_columntodisplay()
	{
		moveto_displaycolumn.click();
	}
	
	public void select_ColumnfromAvailable()
	{
		for(WebElement x:select_available_columns)
		{
			if(x.getText().equals("Active"))
			{
				x.click();
				break;
			}
		}
	}
	
	
	public WebElement account_fileUpload()
	{
		return account_file;
	}
	
	public void click_ListViewDropDown()
	{
		btn_listview.click();
	}
	
	public void select_listviewoption_new()
	{
		for(WebElement x:options_listview)
		{
			if(x.getText().equals("New"))
			{
				x.click();
				break;
			}
		}
	}
	
	public void select_listviewoption_delete()
	{
		for(WebElement x:options_listview)
		{
			if(x.getText().equals("Delete"))
			{
				x.click();
				break;
			}
		}
	}
	
	public void select_listviewoption_displayfields()
	{
		for(WebElement x:options_listview)
		{
			if(x.getText().equals("Select Fields to Display"))
			{
				x.click();
				break;
			}
		}
	}
	
	public void enter_listviewname()
	{
		txt_listview_name.sendKeys("moh_auto");
	}
	
	public void click_listview_api_field()
	{
		txt_listview_name_api.click();
	}
	
	public void click_listview_save()
	{
		btn_listview_save.click();
	}
	
}
