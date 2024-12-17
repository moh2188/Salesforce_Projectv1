package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.DataProviders;

public class TC002_LoginDDT extends BaseClass {

	@Test(dataProvider="loginDDT",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String username,String pwd,String res) throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		
		try {
		lp.enter_username(username);
		lp.enter_password(pwd);
		lp.click_login();
		Thread.sleep(5000);
				
		boolean check=lp.check_globalsearch();
		
		System.out.println(check);
		
		if(res.equalsIgnoreCase("valid"))
		{
			if(check==true)
			{
				System.out.println("res(valid) & search(true)login successfull");
				hp.click_profile();
				hp.click_logout();
				Assert.assertTrue(true);
			}
			if(check==false)
			{
				System.out.println("res(valid) & search(false)login unsuccessfull");
				Assert.assertTrue(false);
			}
		}
		if(res.equalsIgnoreCase("invalid"))
		{
			if(check==true)
			{
				System.out.println("res(invalid) & search(true)invalid login successful");
				hp.click_profile();
				hp.click_logout();
				Assert.assertTrue(false);
			}
			if(check==false)
			{
				System.out.println("res(invalid) & search(true)invalid login unsuccessful");
				Assert.assertTrue(true);
			}
			
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}
	
}
