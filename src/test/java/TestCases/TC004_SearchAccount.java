package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class TC004_SearchAccount extends BaseClass{
	
	
	@Test
	public void verify_search_account() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.enter_username(p.getProperty("username"));
		lp.enter_password(p.getProperty("password"));
		lp.click_login();
		
		Thread.sleep(3000);
		
		hp.click_applauncher();
		hp.txt_applauncher_search(p.getProperty("applauncher_object"));
		Thread.sleep(3000);
		hp.res_app(p.getProperty("applauncher_object"));
		
		Thread.sleep(3000);		
		hp.click_globalsearch();
		//Thread.sleep(3000);
		hp.click_globalsearch_dropdown();
		//Thread.sleep(3000);
		hp.select_globalsearch_dropdown();
		hp.enter_text_globalsearch(p.getProperty("accountName"));
		Thread.sleep(3000);
		hp.select_globalsearch_option(p.getProperty("accountName"));
	
		String acct_name=p.getProperty("accountName");
		
		String conf_accnt=hp.conf_account();
		
		if(acct_name.equals(conf_accnt))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
				
	}
	
}