package Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GraphPage;
import pages.MainPage;
import Main.Help;
import Main.WebDrInit;

public class _20_SelectVertex extends WebDrInit{
	
	/*
	 * Verify vertices are returned to its original place after move. on graph page
	 */

	@SuppressWarnings({ "unused", "static-access" })
	@Test(groups = "graphPage")
	public void _20_T_SelectVertex() throws IOException, InterruptedException {

		MainPage mainPage = new MainPage(driver);

//		MainPage.inputPerson(Integer.parseInt(DataProv.prop("nNperson")));
		int nPerson = 2;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();		

		mainPage.BuildGraph.click();
		Thread.sleep(2000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		Thread.sleep(500);
		// Get vertex collection
		List<WebElement> circle = graphPage.circleColl();
		Point loc1 = circle.get(0).getLocation();
		System.out.println("location 1 - " + loc1);
		
		// Click on 1-st circle 
		circle.get(0).click();
		Thread.sleep(1000); // need for Chrome and IE
		
		Point loc2 = circle.get(0).getLocation();
		System.out.println("location 2 - " + loc2);
		Assert.assertNotEquals(loc1, loc2); // Assert circles moving
		
		Thread.sleep(500);

//		Actions builder = new Actions(driver);
//		Action move = builder.moveToElement(element, -1, -10).build();
//		move.perform();
//		Action cl = builder.click().build();
//		cl.perform();
		
		// Get collection after moving
		// Click on empty space
		List<WebElement> circle2 = graphPage.circleColl();
		Point loc4 = circle2.get(0).getLocation();
		try {
			Help.mouseClick(loc4);
		} catch (AWTException e) {
		
			e.printStackTrace();
		}
		
		Thread.sleep(1500);
		
//		Dimension size = circle.get(0).getSize();
//		new Actions(driver).moveToElement(circle.get(0), size.getWidth()-1, size.getHeight()-10).click().perform();
		List<WebElement> circle3 = graphPage.circleColl();
		Point loc3 = circle3.get(0).getLocation();
		System.out.println("location 3 - " + loc3);
		Assert.assertEquals(loc3, loc1, "Vertices are not returned to its original place.");

	}

}
