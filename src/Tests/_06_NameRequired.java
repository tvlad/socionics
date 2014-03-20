package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _06_NameRequired extends WebDrInit {
	
	/*
	 * Verify entering data into 'Name field'. 
	 */
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _06_T_NameRequired() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);
		
		mainPage.AddPerson.click();
		Assert.assertFalse(mainPage.RequiredColl().get(0).isDisplayed());
		mainPage.DetectButt().get(0).click();
		
		mainPage.DetectButt().get(1).click();
		mainPage.TestLink.click();
		Thread.sleep(500);
		
		Assert.assertTrue(mainPage.RequiredColl().get(0).isDisplayed());
		Assert.assertTrue(mainPage.RequiredColl().get(1).isDisplayed());
		
		Assert.assertEquals(mainPage.RequiredColl().get(0).getText(), "required");
		Assert.assertEquals(mainPage.RequiredColl().get(1).getText(), "required");
	}

}
