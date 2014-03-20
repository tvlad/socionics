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

public class _26_AddPersonFromGraph extends WebDrInit{
	

	/*
	 * Click on vertex
	 */

	@SuppressWarnings({ "unused", "static-access"})
	@Test(groups = "graphPage")
	public void _25_T_ClickOnVertex() throws IOException, InterruptedException {

		MainPage mainPage = new MainPage(driver);

		int nPerson = 2;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();	
		
		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		graphPage.AddPersonFromGraph.click();
		
		Thread.sleep(3000);
		System.out.println("text - " );
		
//		Assert.assertEquals(graphPage.NameOnRightGraph.getText(), "");

		Thread.sleep(2000);
		


	}

}
