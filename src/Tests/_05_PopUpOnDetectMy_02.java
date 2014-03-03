package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Main.WebDrInit;
import pages.MainPage;

public class _05_PopUpOnDetectMy_02 extends WebDrInit{
	
	
	
	/*
	 * Verify that the pop-up message for the 'Detect team chemistry score' button exist.
	 */
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _05_T_PopUpOnDetectMy_02() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);
		
		mainPage.inputPerson(3);
		mainPage.clickAndTestAll();

		Thread.sleep(500);
		
		Assert.assertEquals(mainPage.BuildGraph.getAttribute("popover"), "You can click on button 'Detect team chemistry score'");
		
		Thread.sleep(500);
		
		mainPage.AddPerson.click();
		
		mainPage.DeleteColl().get(1).click();
		mainPage.DeleteColl().get(1).click();
		
		Thread.sleep(3000);
		
		System.out.println("popover - " + mainPage.BuildGraph.getAttribute("popover"));
		
		Assert.assertEquals(mainPage.BuildGraph.getAttribute("popover"), "You need to add at least two people to build a graph!");
		
		
	}

}
