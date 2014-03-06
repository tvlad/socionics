package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TestPage;
import Main.Help;
import Main.Random;
import Main.WebDrInit;

public class _16_FwBwArrows extends WebDrInit{

	
	/*
	 * Verify functionality "backward" and "forward" between questions
	 */


	@SuppressWarnings("static-access")
	@Test(groups = "testPage")
	public void _15_T_QqDiscByMyself() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);
		mainPage.inputPerson(1);
		mainPage.DetectButt().get(0).click();
		mainPage.TestLinkColl().get(0).click();

		Thread.sleep(500);
		
		TestPage testPage = new TestPage(driver);

//		WebElement fgh = testPage.QNum;
//		String nQ = Help.splitStr(fgh.getText(), " ")[1];
//		System.out.println("sdf - " + nQ);
		
		testPage.TestButtColl().get(Random.rInt()).click();
		testPage.ToPrevLink.click();
		Assert.assertEquals(Help.splitStr(testPage.QNum.getText(), " ")[1], "1");
		
		testPage.ToNextLink.click();
		Assert.assertEquals(Help.splitStr(testPage.QNum.getText(), " ")[1], "2");
		
		Thread.sleep(500);

	}
}
