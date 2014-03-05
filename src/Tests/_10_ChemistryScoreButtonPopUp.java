package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.Help;
import Main.WebDrInit;

public class _10_ChemistryScoreButtonPopUp extends WebDrInit {

	/*
	 * Verify text in pop-up
	 */


	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _10_T_ChemistryScoreButtonPopUp() throws InterruptedException {
		
		MainPage mainPage = new MainPage(driver);
		
		mainPage.inputPerson(1);
		mainPage.clickAndTestAll();

		WebElement el = mainPage.BuildGraph;

		Help.mouseOverHelp(el);
		String popUpText = mainPage.DetectScorePopUp.getText();
//		System.out.println("popUpText -" + popUpText);
		Assert.assertEquals(popUpText, "You need to add at least two people to build a graph!", "Unexpected text in pop-up");
		
		Thread.sleep(500);

		mainPage.inputPerson(1);
		mainPage.clickAndTestAll();
		
		Help.mouseOverHelp(el);
		String popUpText_2 = mainPage.DetectScorePopUp.getText();
		Assert.assertEquals(popUpText_2, "You can click on button 'Detect team chemistry score'", "Unexpected text in pop-up");
		
		Thread.sleep(500);

	}

//	public void mouseOver(WebElement el) {
//		Actions builder = new Actions(driver);
//		Action move = builder.moveToElement(el).build();
//		move.perform();
//	}

}
