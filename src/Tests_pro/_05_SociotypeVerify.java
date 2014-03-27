package Tests_pro;

import java.io.IOException;
import java.util.ArrayList;
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

public class _05_SociotypeVerify extends WebDrInit{
	
	@SuppressWarnings({"static-access" })
	@Test(groups = "demo")
	public void _05_T_SociotypeVerify() throws InterruptedException, IOException {
		String testName = "_05_SociotypeVerify";
		MainPage mainPage = new MainPage(driver);
		Main.Log.logToFile(testName, fileName);
		Main.Log.logToFile((Help.date()).toString(), fileName);
		driver.get("http://test.socionics.dev.lezgro.com/#/");

		MainPage.inputPerson(16);
		
		
		

//		List<WebElement> sdf = MainPage.InputColl();
//		for (WebElement s : sdf) {
//			String name = s.getAttribute("value");
//			Main.Log.logToFile("test data - " + name, getfileName());
//		}
		Thread.sleep(1000);
		
		List<WebElement> allButt = mainPage.AllButt();
		int df = allButt.size();
		for (int i = 1; i < df; i++) {
			List<WebElement> allButtttt = mainPage.AllButt();
			allButtttt.get(i).click();
			mainPage.TestLink.click();
			test(i-1);
		}
	
//		mainPage.TestButt.click();
//		mainPage.TestLink.click();
//		Thread.sleep(1000);
//
//		TestPage testPage = new TestPage(driver);
//		WebElement QNum = new WebDriverWait(driver, 10)
//				.until(ExpectedConditions.visibilityOf(TestPage.QNum));
//		Assert.assertEquals(QNum.getText(), "Question 1 of 20");
//		Thread.sleep(1000);
//
//		List<WebElement> testButt = TestPage.TestButtColl();
//		for (int i = 0; i < 20; i++) {
//			String nQ = Help.splitStr(QNum.getText(), " ")[1];
//			if (i != 0) {
//				Assert.assertEquals(testPage.ToPrevLink.getText(),
//						"To previous question");
//			}
//
//			Assert.assertEquals(Integer.parseInt(nQ), i + 1);
//			Thread.sleep(1000);
//			testButt.get(Random.rInt()).click();
//		}
//
//		TestResultPage testResultPage = new TestResultPage(driver);
//
//		@SuppressWarnings("unused")
//		WebElement sociotype = new WebDriverWait(driver, 10)
//				.until(ExpectedConditions
//						.visibilityOf(testResultPage.DefinedSociotype));
//		
//		String script = "return document.getElementsByClassName('text bold-text ng-binding')[0].innerHTML;";
//		String spanText = (String) ((JavascriptExecutor) driver).executeScript(script);
//		System.out.println(spanText);
//
//		testResultPage.GoToTeam.click();
//
//		List<WebElement> socColl = mainPage.SocioLink();
//		String[] gfh = Help.splitStr(spanText, " ");
//		String so = "";
//		for (int i = 0; i < gfh.length; i++) {
//			so = so + gfh[i].substring(0, 1);
//		}
//
//		Assert.assertEquals(socColl.get(0).getText(), so);

	}
	
	public List<String> test(int r) throws InterruptedException {
		List<String> listTest = new ArrayList<String>();
		TestPage testPage = new TestPage(driver);
		WebElement QNum = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(TestPage.QNum));
		Thread.sleep(1000);
		
		List<String> kjh = Help.textFromFile("sociotypes");
		String[] kj = Help.splitStr(kjh.get(r), " ");
		
		
		List<WebElement> testButt = TestPage.TestButtColl();
		for (int i = 0; i < 4; i++) {
			
			testButt.get(Integer.parseInt(kj[i+1])).click();
		}
		TestResultPage testResultPage = new TestResultPage(driver);
		testResultPage.GoToTeam.click();
		
		
		
		return null;
		
	}


}
