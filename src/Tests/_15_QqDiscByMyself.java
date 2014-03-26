package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TestPage;
import Main.Help;
import Main.WebDrInit;

public class _15_QqDiscByMyself extends WebDrInit{
	
	/*
	 * Verify that "discover by myself" consists 4 questions.
	 */


	@SuppressWarnings("static-access")
	@Test(groups = "testPage")
	public void _15_T_QqDiscByMyself() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);
		mainPage.inputPerson(2);
		mainPage.DetectButt().get(1).click();
		mainPage.TestLink.click();

		Thread.sleep(500);
		
		TestPage testPage = new TestPage(driver);

		WebElement fgh = testPage.QNum;

		String nQ = Help.splitStr(fgh.getText(), " ")[3];
		
		Assert.assertEquals(nQ, "4");
		
		Thread.sleep(500);

	}

}
