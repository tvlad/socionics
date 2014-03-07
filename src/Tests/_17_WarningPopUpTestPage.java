package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.TestPage;
import Main.WebDrInit;

public class _17_WarningPopUpTestPage extends WebDrInit{
	
	
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
		
//		System.out.println("text - " + testPage.WarningPopUp.getText());
		Assert.assertTrue(testPage.WarningPopUp.isDisplayed());
		Assert.assertEquals(testPage.WarningPopUp.getText(), "Login and save your changed");
		
		Thread.sleep(1500);

	}

}
