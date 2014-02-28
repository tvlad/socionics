package Tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.Help;
import Main.WebDrInit;

public class _02_LogIn extends WebDrInit{
	
		/*
		 * 
		 * 
		 */
	@Test(groups = "demo")
	public void _02_T_LogIn() throws InterruptedException, IOException {
		MainPage mainPage = new MainPage(driver);
		Main.Log.logToFile((Help.date()).toString(), fileName);
		Main.Log.logToFile("_02_T_LogIn", fileName);

		mainPage.logIn();

		Assert.assertEquals(MainPage.InputColl().get(1).getAttribute("value"),
				getLogin());
	}
		
		

		
		

}
