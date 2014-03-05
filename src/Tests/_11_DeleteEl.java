package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Main.Help;
import Main.WebDrInit;
import pages.MainPage;

public class _11_DeleteEl extends WebDrInit {

	/*
	 * Verify presence of elements "Delete".
	 */

	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _11_T_DeleteEl() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);

		Boolean df = Help.isEnableElements(mainPage.DeleteButton());
		Assert.assertTrue(df, "sf sd");

		// System.out.println("dfgg - " + df);
		// System.out.println("dfdg - " + mainPage.DeleteButton().size());

		mainPage.AddPerson.click();
		Thread.sleep(2000);

		Assert.assertEquals(mainPage.DeleteButton().size(), 2);

		mainPage.DeleteButton().get(1).click();

		Boolean vb = Help.isEnableElements(mainPage.DeleteButton());
		Assert.assertTrue(vb, "sf sd");

	}

}
