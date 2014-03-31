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
import Main.WebDrInit;

public class _27_LineSwitch extends WebDrInit{
	

	/*
	 * LineSwitch assert
	 */



	@Test(groups = "graphPage")
	public void _27_T_LineSwitch() throws IOException, InterruptedException {

		MainPage mainPage = new MainPage(driver);

		int nPerson = 4;
		MainPage.inputPerson(nPerson);
		mainPage.clickAndTestAll();	
		
		mainPage.BuildGraph.click();
		Thread.sleep(1000);
		GraphPage graphPage = new GraphPage(driver);
		
		// Verified for load graph page
		WebElement dropDownAll = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(graphPage.DropDownAll));
		
		List<WebElement> dropDownPosition = graphPage.DropDownPosition();
		for (int i = 0; i < dropDownPosition.size(); i++) {
			dropDownAll.click();
			dropDownPosition.get(i).click();

			List<WebElement> lines = graphPage.lineVisibleColl();
			
			if (lines.size() > 0){

				String col = "";
				for (WebElement line : lines) {
					String color = line.getAttribute("stroke");
					
					switch (i) {
					case 1:
						col = "#51a351";
						Assert.assertEquals(color, col);
						break;
					case 2:
						col = "#49afcd";
						Assert.assertEquals(color, col);
						break;
					case 3:
						col = "#04c";
						Assert.assertEquals(color, col);
						break;
					case 4:
						col = "#FA33F1";
						Assert.assertEquals(color, col);
						break;
					case 5:
						col = "#faa732";
						Assert.assertEquals(color, col);
						break;
					case 6:
						col = "#da4f49";
						Assert.assertEquals(color, col);
						break;
					default:
						Assert.assertEquals(lines.size(), graphPage.lineAllColl().size());
					}
				}
			}

			
			
			Thread.sleep(1000);
		}
		

		
		Thread.sleep(1000);

//		Best				#51a351
//		Good				#49afcd
//		Neutral				#04c
//		Misunderstanding	#FA33F1
//		Tensed				#faa732
//		Undesirable			#da4f49
	
//		Thread.sleep(1000); 

	}
	

}




