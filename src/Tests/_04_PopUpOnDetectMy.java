package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _04_PopUpOnDetectMy extends WebDrInit {
	
	
	/*
	 * Verify that the pop-up message for the 'Detect team chemistry score' button exist.
	 */
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _04_T_PopUpOnDetectMy() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);

		Thread.sleep(1000);
		
		Assert.assertEquals(mainPage.BuildGraph.getAttribute("popover"), "You need to add at least two people to build a graph!");
		
		mainPage.AddPerson.click();
		
		Assert.assertEquals(mainPage.BuildGraph.getAttribute("popover"), "You need to add at least two people to build a graph!");
		
		Thread.sleep(1000);

	}

}
