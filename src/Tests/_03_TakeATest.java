package Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TestPage;
import pages.TestResultPage;
import Main.Help;
import Main.Random;
import Main.WebDrInit;

public class _03_TakeATest extends WebDrInit {

	@Test(groups = "demo")
	public void _03_T_TakeATest() throws InterruptedException, IOException {
		String testName = "_03_T_TakeATest";
		MainPage mainPage = new MainPage(driver);
		Main.Log.logToFile(testName, fileName);
		Main.Log.logToFile((Help.date()).toString(), fileName);

		MainPage.inputPerson(2);

		List<WebElement> sdf = MainPage.InputColl();
		for (WebElement s : sdf) {
			String name = s.getAttribute("value");
			Main.Log.logToFile("test data - " + name, getfileName());
		}
		Thread.sleep(1000);
	
		mainPage.TestButt.click();
		mainPage.TestLink.click();
		Thread.sleep(1000);

		TestPage testPage = new TestPage(driver);
		WebElement QNum = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOf(TestPage.QNum));
		Assert.assertEquals(QNum.getText(), "Question 1 of 20");
		Thread.sleep(1000);

		List<WebElement> testButt = TestPage.TestButtColl();
		for (int i = 0; i < 20; i++) {
			String nQ = Help.splitStr(QNum.getText(), " ")[1];
			if (i != 0) {
				Assert.assertEquals(testPage.ToPrevLink.getText(),
						"To previous question");
			}

			Assert.assertEquals(Integer.parseInt(nQ), i + 1);
			Thread.sleep(1000);
			testButt.get(Random.rInt()).click();
		}

		TestResultPage testResultPage = new TestResultPage(driver);

		@SuppressWarnings("unused")
		WebElement sociotype = new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOf(testResultPage.DefinedSociotype));
		
		String script = "return document.getElementsByClassName('text bold-text ng-binding')[0].innerHTML;";
		String spanText = (String) ((JavascriptExecutor) driver).executeScript(script);
		System.out.println(spanText);

		testResultPage.GoToTeam.click();

		List<WebElement> socColl = mainPage.SocioLink();
		String[] gfh = Help.splitStr(spanText, " ");
		String so = "";
		for (int i = 0; i < gfh.length; i++) {
			so = so + gfh[i].substring(0, 1);
		}

		Assert.assertEquals(socColl.get(0).getText(), so);

	}

}
