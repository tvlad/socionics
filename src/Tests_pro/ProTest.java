package Tests_pro;


import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class ProTest extends WebDrInit {

	/*
	 * Verify that the pop-up message for the login button exist.
	 */

	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _00_T_Pro() throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		
//		System.out.println("text - " + mainPage.DetectButt().get(0).getText());
		
		mainPage.logIn();
		Thread.sleep(3000);
		mainPage.inputPerson(9);
		Thread.sleep(1000);
		mainPage.clickAndTestAll();
		
//		mainPage.AddPerson.click();
		
//		int fg = mainPage.InputColl().size() - 3;
//		
//		String fgfh = mainPage.InputColl().get(fg).getAttribute("value");
//		
//		System.out.println("fghf -" + fgfh);
//		
//		mainPage.inputPerson(1);
//		
//		Thread.sleep(4000);
		
//		mainPage.inputPerson(2);

	}

}
