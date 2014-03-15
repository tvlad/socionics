package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.GraphPage;
import pages.MainPage;
import Main.WebDrInit;

public class _21_ClickOnLine extends WebDrInit{
	
	/*
	 * Verify click on line 
	 */

	@SuppressWarnings("unused")
	@Test(groups = "graphPage")
	public void _21_T_ClickOnLine() throws IOException, InterruptedException {

		MainPage mainPage = new MainPage(driver);

//		MainPage.inputPerson(Integer.parseInt(DataProv.prop("nNperson")));
		int nPerson = 3;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();		

		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		Thread.sleep(500);
		
		List<WebElement> lines = graphPage.lineColl();
		for (WebElement li : lines) {
			System.out.println("li - " + li);
		}
		
		lines.get(0).click();
		
		Thread.sleep(2000);


	}


}
