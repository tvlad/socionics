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
	 * Verify presence of elements on graph page
	 */

	@SuppressWarnings("unused")
	@Test(groups = "graphPage")
	public void _09_T_CommonElementsGraph() throws IOException, InterruptedException {

		MainPage mainPage = new MainPage(driver);

//		MainPage.inputPerson(Integer.parseInt(DataProv.prop("nNperson")));
		int nPerson = 2;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();		

		mainPage.BuildGraph.click();
		Thread.sleep(2000);
		GraphPage graphPage = new GraphPage(driver);
		
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		Thread.sleep(2000);

		
		List<WebElement> circle = graphPage.circleColl();
		Point loc1 = circle.get(0).getLocation();
		System.out.println("location 1 - " + loc1);
		circle.get(0).click();
		Point loc2 = circle.get(0).getLocation();
		System.out.println("location 2 - " + loc2);
		Assert.assertNotEquals(loc1, loc2);
		
		Thread.sleep(2000);
		
		List<WebElement> circle2 = graphPage.circleColl();
		
		WebElement element = circle2.get(0);

//		Actions builder = new Actions(driver);
//		Action move = builder.moveToElement(element, -1, -10).build();
//		move.perform();
//		Action cl = builder.click().build();
//		cl.perform();
//		
		
		Point loc4 = circle2.get(0).getLocation();
		try {
			Help.mouseClick(loc4);
		} catch (AWTException e) {
		
			e.printStackTrace();
		}
		
		
//		Dimension size = circle.get(0).getSize();
//		new Actions(driver).moveToElement(circle.get(0), size.getWidth()-1, size.getHeight()-10).click().perform();
		List<WebElement> circle3 = graphPage.circleColl();
		Point loc3 = circle3.get(0).getLocation();
		System.out.println("location 3 - " + loc3);
		Thread.sleep(3000);

	}

}
