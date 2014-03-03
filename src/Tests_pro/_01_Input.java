package Tests_pro;

//import org.testng.Assert;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Main.DataProv;
import Main.Help;
import Main.WebDrInit;
import pages.MainPage;
import pages.TestPage;

public class _01_Input extends WebDrInit {

	/*
	 * 
	 * 
	 */
	@Test(groups = "demo")
	public void _01_T_Input() throws InterruptedException, IOException {
		String testName = "_01_T_Input";
		MainPage mainPage = new MainPage(driver);
		Main.Log.logToFile((Help.date()).toString(), fileName);
		Main.Log.logToFile(testName, fileName);

		// inputNnPerson(Integer.parseInt(DataProv.prop("nNperson")) - 1);
		MainPage.inputPerson(Integer.parseInt(DataProv.prop("nNperson")));

		Thread.sleep(2000);
		List<WebElement> sdf = MainPage.InputColl();
		for (WebElement s : sdf) {
			String name = s.getAttribute("value");
			Main.Log.logToFile(("test data - " + name), getfileName());
		}

		mainPage.TestButt.click();
		mainPage.TestLink.click();
		Thread.sleep(2000);

		TestPage testPage = new TestPage(driver);
		@SuppressWarnings("static-access")
		WebElement QNum = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOf(testPage.QNum));
		Assert.assertEquals(QNum.getText(), "Question 1 of 20");
		Thread.sleep(1000);
	}
}
