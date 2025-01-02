package TestCases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.AccountApprovalPage;
import PageObjects.EditAccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class TC007_AccountApproval extends BaseClass{
	
	@Test
	public void verify_accountapproval() throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		EditAccountPage ep=new EditAccountPage(driver);
		AccountApprovalPage ap=new AccountApprovalPage(driver);
		
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
		Thread.sleep(3000);
		hp.click_globalsearch_dropdown();
		Thread.sleep(3000);
		hp.select_globalsearch_dropdown(p.getProperty("applauncher_object"));
		hp.enter_text_globalsearch(p.getProperty("accountName"));
		Thread.sleep(3000);
		hp.select_globalsearch_option(p.getProperty("accountName"));
		Thread.sleep(3000);
		
		ep.click_account_dropdown();
		Thread.sleep(2000);
		ap.click_account_approval(p.getProperty("acct_dropdown"));
		Thread.sleep(2000);
		
		ap.enter_appcomment();
		ap.click_submitapp();
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		hp.click_applauncher();
		Thread.sleep(3000);
		hp.txt_applauncher_search(p.getProperty("applauncher_object"));
		Thread.sleep(3000);
		hp.res_app(p.getProperty("applauncher_object"));
		Thread.sleep(3000);
		
		hp.click_globalsearch();
		Thread.sleep(5000);
		hp.click_globalsearch_dropdown();
		Thread.sleep(5000);
		ap.select_gdrp_option(p.getProperty("applauncher_object"));
		Thread.sleep(5000);
		hp.enter_text_globalsearch(p.getProperty("accountName"));
		Thread.sleep(3000);
		hp.select_globalsearch_option(p.getProperty("accountName"));
		Thread.sleep(3000);
		
			
		ap.click_approve1();
		Thread.sleep(3000);
		ap.click_approve2();
		
				
	}

}
