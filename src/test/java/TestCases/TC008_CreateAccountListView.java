package TestCases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.AccountRelatedPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;



public class TC008_CreateAccountListView extends BaseClass{

	@Test
	public void verify_AccListView() throws InterruptedException
	{
	LoginPage lp=new LoginPage(driver);
	HomePage hp=new HomePage(driver);
	AccountRelatedPage ap=new AccountRelatedPage(driver);
	
	lp.enter_username(p.getProperty("username"));
	lp.enter_password(p.getProperty("password"));
	lp.click_login();
	Thread.sleep(3000);
	
	hp.click_applauncher();
	hp.txt_applauncher_search(p.getProperty("applauncher_object"));
	Thread.sleep(3000);
	hp.res_app(p.getProperty("applauncher_object"));
	Thread.sleep(3000);
	
	ap.click_ListViewDropDown();
	ap.select_listviewoption_new();
	ap.enter_listviewname();
	ap.click_listview_api_field();
	ap.click_listview_save();
	ap.click_ListViewDropDown();
	ap.select_listviewoption_displayfields();
	ap.select_ColumnfromAvailable();
	ap.move_columntodisplay();
	ap.select_ColumnfromDisplay();
	ap.moveup_displaycolumn();
	ap.click_saveListViewUpdate();
	Thread.sleep(3000);
	
	
	
	
	
	}
	
}
