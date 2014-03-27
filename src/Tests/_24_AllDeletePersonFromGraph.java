package Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GraphPage;
import pages.MainPage;
import Main.WebDrInit;

public class _24_AllDeletePersonFromGraph extends WebDrInit{
	
	
	/*
	 * Delete All Persons From Graph
	 */

	@SuppressWarnings({ "unused", "static-access"})
	@Test(groups = "graphPage")
	public void _24_T_AllDeletePersonFromGraph() throws IOException, InterruptedException {

		
		MainPage mainPage = new MainPage(driver);

		int nPerson = 10;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();	
		
		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		graphPage.delAllPer();
		
		Thread.sleep(500);
		
		Assert.assertEquals(mainPage.AllButt().size(), 1);

	}


}
