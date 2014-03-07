package Tests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TestPage;
import pages.TestResultPage;
import Main.Help;
import Main.WebDrInit;

public class _18_SocTypeAssert extends WebDrInit{
	
	
	/*
	 * Verify pop-up unlogin warning after testing
	 */


	@SuppressWarnings({ "static-access"})
	@Test(groups = "testPage")
	public void _17_T_WarningPopUpTestPage() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);
		mainPage.inputPerson(1);
		mainPage.DetectButt().get(0).click();
		mainPage.TestLinkColl().get(0).click();

		Thread.sleep(500);
		
		TestPage testPage = new TestPage(driver);
		
		testPage.takeTestWithOutReturn();
		
		TestResultPage testResultPage = new TestResultPage(driver);
		
		String script = "return document.getElementsByClassName('text bold-text ng-binding')[0].innerHTML;";
		String spanText = (String) ((JavascriptExecutor) driver).executeScript(script);
//		System.out.println(spanText);
		
		testResultPage.GoToTeam.click();
		
		List<WebElement> socColl = mainPage.SocioLink();
		String[] gfh = Help.splitStr(spanText, " ");
		String so = "";
		for (int i = 0; i < gfh.length; i++) {
			so = so + gfh[i].substring(0, 1);
		}

		Assert.assertEquals(socColl.get(0).getText(), so);
		
		Thread.sleep(500);

	}

}
