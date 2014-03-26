package Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TestPage;
import Main.Help;
import Main.WebDrInit;

public class _14_QqForMyself extends WebDrInit{
	/*
	 * Verify that "testing for myself" consists 20 questions.
	 */


	@SuppressWarnings("static-access")
	@Test(groups = "testPage")
	public void _14_T_QqForMyself() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);
		mainPage.inputPerson(1);
		mainPage.DetectButt().get(0).click();
		

		Thread.sleep(500);
		
		TestPage testPage = new TestPage(driver);

		WebElement fgh = testPage.QNum;

		String nQ = Help.splitStr(fgh.getText(), " ")[3];
		
		Assert.assertEquals(nQ, "20");
		
		Thread.sleep(500);

	}

}
