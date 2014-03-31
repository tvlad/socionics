package Tests_pro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TestPage;
import pages.TestResultPage;
import Main.Help;
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

		Thread.sleep(500);
		
		List<WebElement> allButt = mainPage.AllButt();
		int df = allButt.size();
		for (int i = 1; i < df; i++) {
			List<WebElement> allButtttt = mainPage.AllButt();
			allButtttt.get(i).click();
			mainPage.TestLink.click();
			String vbn = test(i - 1);
			Thread.sleep(1000);
			List<WebElement> testedButton = mainPage.UnDetectButt();
			System.out.println("soc - " + testedButton.get(i-1).getText() + " ---- " + vbn);
			Assert.assertEquals(testedButton.get(i-1).getText(), vbn);
		}

	}
	
	@SuppressWarnings("unused")
	public String test(int r) throws InterruptedException {
		List<String> listTest = new ArrayList<String>();
		TestPage testPage = new TestPage(driver);
		WebElement QNum = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(TestPage.QNum));
		Thread.sleep(500);
		
		List<String> kjh = Help.textFromFile("sociotypes");
		String[] kj = Help.splitStr(kjh.get(r), " ");
		
		List<WebElement> testButt = TestPage.TestButtColl();
		for (int i = 0; i < 4; i++) {
			testButt.get(Integer.parseInt(kj[i + 1])).click();
		}
		TestResultPage testResultPage = new TestResultPage(driver);
		testResultPage.GoToTeam.click();

		return kj[0];
	}


}
