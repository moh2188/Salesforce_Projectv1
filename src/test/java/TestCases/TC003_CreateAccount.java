package TestCases;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.CreateAccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class TC003_CreateAccount extends BaseClass {

	
	@Test
	public void verify_create_account() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.enter_username(p.getProperty("username"));
		lp.enter_password(p.getProperty("password"));
		lp.click_login();
		Thread.sleep(3000);
		
		hp.click_applauncher();
		hp.txt_applauncher_search(p.getProperty("applauncher_object"));
		Thread.sleep(5000);
		hp.res_app(p.getProperty("applauncher_object"));
		
		CreateAccountPage ap=new CreateAccountPage(driver);
		
		ap.click_new_account_button();
		ap.enter_accountname(p.getProperty("accountName"));
		ap.click_save_account_button();
		Thread.sleep(3000);
		
		
	}
	
	
	
	
	
}
