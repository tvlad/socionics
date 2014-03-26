package Tests;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _13_LockEdit extends WebDrInit {

	/*
	 * Verifying that fields 'Name', 'E-mail' and 'Role' locked for editing
	 * after Testing. Не актуально, на сегодня проверяет, что такого атрибута нет.
	 */

	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _13_T_LockEdit() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);

		Thread.sleep(1000);
		mainPage.inputPerson(2);
		mainPage.clickAndTestAll();
		Thread.sleep(1000);

		for (WebElement el : mainPage.InputColl()) {
			Assert.assertEquals(el.getAttribute("disabled"), null);
		}
	}
}
