package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageObjects.AccountRelatedPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;

public class TC006_AccountRelated extends BaseClass {

	@Test
	public void verify_fileupload() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		AccountRelatedPage ap=new AccountRelatedPage(driver);
		
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
		hp.select_globalsearch_dropdown(p.getProperty("applauncher_object"));
		hp.enter_text_globalsearch(p.getProperty("accountName"));
		Thread.sleep(3000);
		hp.select_globalsearch_option(p.getProperty("accountName"));
		Thread.sleep(5000);	
		
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Scroll up by a certain number of pixels (e.g., 500px)
        js.executeScript("window.scrollBy(0, 300);"); // Scroll up by 500px*/
        		
		WebElement file=ap.account_fileUpload();
		
		file.sendKeys("C:\\\\Users\\\\mohsi\\\\Desktop\\\\Admin.txt");
		
		Thread.sleep(3000);
		
		

		
	}
}
