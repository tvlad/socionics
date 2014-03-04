package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.Help;
import Main.WebDrInit;

public class _01_FacebookAuthorisation extends WebDrInit {
	/*
	 * Verify "login with facebook"
	 * 
	 */
	@Test(groups = "mainPage")
	public void _02_T_FacebookAuthorisation() throws InterruptedException, IOException {
		MainPage mainPage = new MainPage(driver);
		Main.Log.logToFile((Help.date()).toString(), fileName);
		Main.Log.logToFile("_02_T_LogIn", fileName);

		mainPage.logIn(); 
		Thread.sleep(3000);		
		Assert.assertEquals(MainPage.InputColl().get(1).getAttribute("value"),
				getLogin(), "The entered e-mail does not match the e-mail account.");
	}

}
