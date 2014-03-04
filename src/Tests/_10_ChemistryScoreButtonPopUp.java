package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _10_ChemistryScoreButtonPopUp extends WebDrInit {

	/*
	 * Verify text in pop-up
	 */


	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _10_T_ChemistryScoreButtonPopUp() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.inputPerson(4);
		mainPage.clickAndTestAll();

		WebElement el = mainPage.BuildGraph;

		mouseOver(el);
		
		Thread.sleep(2000);
		mainPage.AddPerson.click();
		
		
		mouseOver(el);
		Thread.sleep(2000);
		
		mainPage.inputPerson(1);
		mainPage.clickAndTestAll();
		
		Thread.sleep(2000);

	}

	public void mouseOver(WebElement el) {
		Actions builder = new Actions(driver);
		Action move = builder.moveToElement(el).build();
		move.perform();
	}

}
