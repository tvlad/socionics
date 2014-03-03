package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _08_RoleInput extends WebDrInit{
	
	/*
	 * Verify entering data into 'Role'. 
	 */
	
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _07_RoleInput() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);
		
		mainPage.AddPerson.click();
		mainPage.InputColl().get(2).sendKeys("m");
		String hgh = mainPage.TextForRole.getText();

		mainPage.TextForRole.click();
		
		Thread.sleep(500);
		
		Assert.assertEquals(mainPage.InputColl().get(2).getAttribute("value"), hgh);
		
		
	}

}
