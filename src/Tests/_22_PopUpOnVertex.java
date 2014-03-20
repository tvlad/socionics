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

public class _22_PopUpOnVertex extends WebDrInit{
	
	/*
	 * Verify pop-up text on vertex
	 */

	@SuppressWarnings({ "unused", "static-access" })
	@Test(groups = "graphPage")
	public void _22_T_PopUpOnVertex() throws IOException, InterruptedException {

		
		MainPage mainPage = new MainPage(driver);

		int nPerson = 2;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();	
		
		String name = mainPage.InputColl().get(3).getAttribute("value");
		
		String soc = mainPage.AllButt().get(1).getText();

		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		Thread.sleep(500);
		
		Help.mouseOverHelp(graphPage.circleColl().get(0));
		
		Assert.assertEquals(graphPage.popUpColl().get(0).getAttribute("style"), "display: block;", "Pop-up invisible");
		
		String str = Help.noBr(graphPage.popUpColl().get(0).getText());
		
		String[] popUpText = Help.splitStr(str, ": ");
		
		Assert.assertEquals(name, (popUpText[0] + " " + popUpText[1])); //Проверяет соответствие имени в списке и на поп-апе вершины графа
		
		String socAbb = (popUpText[popUpText.length - 3].substring(0, 1))
				+ (popUpText[popUpText.length - 2].substring(0, 1))
				+ (popUpText[popUpText.length - 1].substring(0, 1));

		Assert.assertEquals(socAbb, soc); //Проверяет соответствие социотипа в списке и на поп-апе вершины графа
		Thread.sleep(500);

	}

}
