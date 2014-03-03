package Tests;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;


public class _03_PopUpOnLogin extends WebDrInit{
	
	
	/*
	 * Verify that the pop-up message for the login button exist.
	 */
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _03_T_PopUpOnLogin() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);
		
		WebElement el = mainPage.LogButt;
		
		Actions builder = new Actions(driver);
		Action move = builder.moveToElement(el).build();
		move.perform();
		Thread.sleep(1000);
		
		Assert.assertEquals(el.getAttribute("popover"), "Login and save your changed");

	}

}
