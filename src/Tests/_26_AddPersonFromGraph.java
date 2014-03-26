package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GraphPage;
import pages.MainPage;
import pages.TestPage;
import Main.WebDrInit;

public class _26_AddPersonFromGraph extends WebDrInit{
	

	/*
	 * Add person from graph page
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
		
		String name = "Raf Air";
		String email = "far_air@cc.com";
		String role = "Boss";
		
		List<WebElement> input =  graphPage.inputFieldsColl();
		input.get(0).sendKeys(name);
		input.get(1).sendKeys(email);
		input.get(2).sendKeys(role);
		
		Thread.sleep(1000);
		
		graphPage.detectButtonGraph.click();
		graphPage.TestLink.click();
		
		Thread.sleep(500);
		
		TestPage testpage = new TestPage(driver);
		testpage.takeTest();
				
		System.out.println("text - " );
		
		Assert.assertEquals(mainPage.AllButt().size(), nPerson + 1);

//		Thread.sleep(1000);
		


	}

}
