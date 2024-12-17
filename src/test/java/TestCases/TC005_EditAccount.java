package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.CreateAccountPage;
import PageObjects.EditAccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class TC005_EditAccount extends BaseClass {

	
	@Test
	public void verify_edit_account() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
	
		
		lp.enter_username(p.getProperty("username"));
		lp.enter_password(p.getProperty("password"));
		lp.click_login();
		
		Thread.sleep(5000);		
		
		hp.click_applauncher();
		hp.txt_applauncher_search(p.getProperty("applauncher_object"));
		Thread.sleep(5000);
		hp.res_app(p.getProperty("applauncher_object"));
		
		Thread.sleep(5000);	
		
		hp.click_globalsearch();
		Thread.sleep(3000);
		hp.click_globalsearch_dropdown();
		hp.select_globalsearch_dropdown();
		hp.enter_text_globalsearch(p.getProperty("accountName"));
		Thread.sleep(3000);
		hp.select_globalsearch_option(p.getProperty("accountName"));
		
		EditAccountPage ep=new EditAccountPage(driver);
		
		ep.click_account_dropdown();
		Thread.sleep(3000);
		ep.click_account_edit();
		Thread.sleep(5000);
		
		ep.click_rating();
		ep.select_rating(p.getProperty("ratingOption"));
		Thread.sleep(3000);
		
		ep.click_editSave();
		Thread.sleep(3000);
		
		String account=hp.conf_account();
		
		if(account.equals(p.getProperty("accountName")))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		

	}
	
		
	
}
