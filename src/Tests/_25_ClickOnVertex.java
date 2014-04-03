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

public class _25_ClickOnVertex extends WebDrInit{
	

	/*
	 * Click on vertex
	 */

	@SuppressWarnings({ "unused", "static-access"})
	@Test(groups = "graphPage")
	public void _25_T_ClickOnVertex() throws IOException, InterruptedException {

		MainPage mainPage = new MainPage(driver);

		int nPerson = 3;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();	
		
		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		graphPage.circleColl().get(nPerson-1).click();
		Thread.sleep(2000);
		Help.mouseOverHelp(graphPage.circleColl().get(nPerson-1));

		String str = Help.noBr(graphPage.popUpColl().get(nPerson-1).getText()); // get text from pop-up and delete /n-symbol
		String[] popUpText = Help.splitStr(str, ": ");
		
//		System.out.println("text - " + str);
		
		System.out.println("text - " + popUpText[0] + " " + popUpText[1]);
		System.out.println("text - " + popUpText[3] + " " + popUpText[4] + " " + popUpText[5]);
		
		Assert.assertEquals(graphPage.NameOnRightGraph.getText(), popUpText[0] + " " + popUpText[1]); // Name assert
		Assert.assertEquals(graphPage.SocioOnRightGraph.getText(), popUpText[3] + " " + popUpText[4] + " " + popUpText[5]); // Sociotype assert
		Assert.assertEquals(graphPage.RelationsVarietyHeader.getText(), "Relations Variety");
		Assert.assertEquals(graphPage.PersonalProfileHeader.getText(), "Personal Profile");
		Assert.assertEquals(graphPage.DescriptionHeader.getText(), "Description");
		
		Thread.sleep(2000);

	}
	
	@Test(groups = "graphPage")
	public void _26_T_(){
		GraphPage graphPage = new GraphPage(driver);
		Assert.assertEquals(graphPage.TopFitsHeader.getText(), "Top Fits");
	}

}
