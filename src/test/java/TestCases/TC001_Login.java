package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class TC001_Login extends BaseClass{
	
	@Test
	public void verify_login() throws InterruptedException
	{
				
		LoginPage lp=new LoginPage(driver);
		lp.enter_username(p.getProperty("username"));
		lp.enter_password(p.getProperty("password"));
		lp.click_login();
		Thread.sleep(3000);
		
		HomePage hp=new HomePage(driver);
		
		boolean check=lp.check_globalsearch();
		
		if(check==true)
		{

			hp.click_profile();
			hp.click_logout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
			
		
	}
	

}
