package Tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GraphPage;
import pages.MainPage;
import Main.Help;
import Main.WebDrInit;

public class _21_ClickOnLine extends WebDrInit {

	/*
	 * Verify click on line
	 */

	@SuppressWarnings({ "unused", "static-access" }) 
	@Test(groups = "graphPage")
	public void _21_T_ClickOnLine() throws IOException, InterruptedException {

		MainPage mainPage = new MainPage(driver);

		// MainPage.inputPerson(Integer.parseInt(DataProv.prop("nNperson")));
		int nPerson = 2;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();
		Thread.sleep(2000);
		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);

		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));

		List<WebElement> lines = graphPage.lineAllColl();

		String[] popUpText = graphPage.textFromPopUp(graphPage.circleColl()
				.get(0), graphPage.VisibleVertexPopUp); // pop-up text in first vertex
		Thread.sleep(1000);
		
		System.out.println("popUpText - " + popUpText[popUpText.length - 3] + " " + popUpText[popUpText.length - 2] + " " + popUpText[popUpText.length - 1]);
		String[] popUpText2 = graphPage.textFromPopUp(graphPage.circleColl()
				.get(1), graphPage.VisibleVertexPopUp); // pop-up text in second vertex
		Thread.sleep(1000);
		
		System.out.println("popUpText2 - " + popUpText2[popUpText2.length - 3] + " "  + popUpText2[popUpText.length - 2] + " " + popUpText2[popUpText.length - 1]);
				String[] popUpText3 = graphPage.textFromPopUp(lines.get(0),
				graphPage.VisibleLinePopUp); // pop-up text in line pop-up
		Thread.sleep(1000);
		String popUpText4 = graphPage.srtingFromPopUp(lines.get(0),	graphPage.VisibleLinePopUp).substring(22);
		System.out.println("sub from pop-up - " + popUpText4);

		// Help.mouseOverHelp(graphPage.circleColl().get(0));
		// String str = Help.noBr(graphPage.VisibleVertexPopUp.getText()); //
		// get text from pop-up and delete //n-symbol
		// String[] popUpText = Help.splitStr(str, ": ");

		lines.get(0).click();

		// Name assertes
		Assert.assertEquals(graphPage.NameOnLineClickColl().get(0).getText(),
				popUpText[0] + " " + popUpText[1]);
		Assert.assertEquals(graphPage.NameOnLineClickColl().get(1).getText(),
				popUpText2[0] + " " + popUpText2[1]);

		// Siciotype assertes
		Assert.assertEquals(graphPage.SociotypeOnLineClickColl().get(0)
				.getText(), popUpText[popUpText.length - 3] + " "
				+ popUpText[popUpText.length - 2] + " "
				+ popUpText[popUpText.length - 1]);

		Assert.assertEquals(graphPage.SociotypeOnLineClickColl().get(1)
				.getText(), popUpText2[popUpText2.length - 3] + " "
				+ popUpText2[popUpText.length - 2] + " "
				+ popUpText2[popUpText.length - 1]);
		

		// Compatibility type assert
		Assert.assertEquals(graphPage.CompatibilityType.getText(),
				popUpText4);

		// Compatibility color assert
		
		String script = "return document.getElementsByClassName('label ng-binding')[0].getAttribute('style');"; // get non-modified attribute
		String spanText = (String) ((JavascriptExecutor) driver).executeScript(script);
		
		System.out.println("text - " + spanText.substring(18));
		System.out.println("col2 - " + graphPage.lineAllColl().get(0).getAttribute("stroke"));

		Assert.assertEquals(spanText.substring(18), graphPage.lineAllColl().get(0).getAttribute("stroke"));
		
		Thread.sleep(2000);
		
		
//		Assert Return to its original state
		try {
			Help.mouseClick(graphPage.circleColl().get(0).getLocation());
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(graphPage.persentOfRel.isDisplayed());

		
//		List<WebElement> col = graphPage.RelateRowColl();
//		System.out.println("col - " + col.size());
//		for (WebElement c : col) {
//			String fill = c.getAttribute("fill");
//			System.out.println("-------------------------------------");
//			System.out.println("c - " + fill);
//			
//		}
		Thread.sleep(2000);

	}
}
