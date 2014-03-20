package Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GraphPage;
import pages.MainPage;
import Main.Help;
import Main.WebDrInit;

public class _23_DeletePersonFromGraph extends WebDrInit{
	
	/*
	 * Delete Person From Graph
	 */

	@SuppressWarnings({ "unused", "static-access"})
	@Test(groups = "graphPage")
	public void _23_T_DeletePersonFromGraph() throws IOException, InterruptedException {

		
		MainPage mainPage = new MainPage(driver);

		int nPerson = 3;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();	
		
		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		Help.mouseOverHelp(graphPage.circleColl().get(0));
		graphPage.circleDelColl().get(0).click();
		
//		Alert alert = (new WebDriverWait(driver, 3))
//                .until(ExpectedConditions.alertIsPresent());
//		alert.accept();
		
		graphPage.AlertOK.click();
				
		Thread.sleep(500);
		
		graphPage.ListViewButton.click();
		
		Thread.sleep(500);
		
		Assert.assertEquals(mainPage.AllButt().size(), nPerson -1);

	}


}
