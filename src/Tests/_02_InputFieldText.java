package Tests;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _02_InputFieldText extends WebDrInit {

	/*
	 * Verify default text for "person`s data" fields.
	 */
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _02_T_nputFieldText() throws InterruptedException, IOException {
		MainPage mainPage = new MainPage(driver);

		mainPage.AddPerson.click();
		
		Thread.sleep(1000);

		Assert.assertEquals(
				MainPage.InputColl().get(0).getAttribute("placeholder"),
				"Your full name", "Wrong default text in 'Your Name' field");
		
		Assert.assertEquals(
				MainPage.InputColl().get(1).getAttribute("placeholder"),
				"Your e-mail", "Wrong default text in 'Your E-Mail' field");
		
		Assert.assertEquals(
				MainPage.InputColl().get(2).getAttribute("placeholder"),
				"Your role", "Wrong default text in 'Your role' field");
		
		Assert.assertEquals(
				MainPage.InputColl().get(3).getAttribute("placeholder"),
				"Person's full name", "Wrong default text in 'Their name' field");
		
		Assert.assertEquals(
				MainPage.InputColl().get(4).getAttribute("placeholder"),
				"Their e-mail", "Wrong default text in 'Their e-mail' field");
		
		Assert.assertEquals(
				MainPage.InputColl().get(5).getAttribute("placeholder"),
				"Their role", "Wrong default text in 'Their role' field");


	}
	
	
	/*
	 * Verify that the pop-up message for the login button exist.
	 */
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _03_T_PopUpOnLogin() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);
		
		WebElement el = mainPage.LogButt;
		
		Actions builder = new Actions(driver);
		Action move = builder.moveToElement(el).build();
		move.perform();
		Thread.sleep(1000);
		
		Assert.assertEquals(el.getAttribute("popover"), "Login and save your changed");

	}

}
