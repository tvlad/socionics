package Tests;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _07_IllegalMail extends WebDrInit{
	
	/*
	 * Verify entering data into 'E-mail'. 
	 */
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _07_T_IllegalMail() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);
		
		mainPage.AddPerson.click();
		Assert.assertFalse(mainPage.MailWarningColl().get(0).isDisplayed());
		mainPage.InputColl().get(1).sendKeys("sdf");
		Assert.assertTrue(mainPage.MailWarningColl().get(0).isDisplayed());
		mainPage.InputColl().get(4).sendKeys("sdf");
		Assert.assertTrue(mainPage.MailWarningColl().get(1).isDisplayed());
		
		mainPage.InputColl().get(1).clear();
		mainPage.InputColl().get(4).clear();
		
		mainPage.InputColl().get(1).sendKeys("sdf@fgh.fg");
		mainPage.InputColl().get(4).sendKeys("sbf@hg.fb");
		Thread.sleep(500);
		
		List<WebElement> fg = mainPage.MailWarningColl();
		
//		System.out.println("bool1 - " + fg.get(0).isDisplayed());
//		System.out.println("bool2 - " + fg.get(1).isDisplayed());
		
		Assert.assertFalse(fg.get(0).isDisplayed());
		Assert.assertFalse(fg.get(1).isDisplayed());
		
		Thread.sleep(500);
	}


}
