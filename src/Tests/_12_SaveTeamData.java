package Tests;

//import org.testng.Assert;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _12_SaveTeamData extends WebDrInit {

	/*
	 * Verifying successful save information about the team.
	 */

	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _12_T_SaveTeamData() throws InterruptedException {

		MainPage mainPage = new MainPage(driver);

		mainPage.logIn();
		Thread.sleep(1000);
		mainPage.inputPerson(1);
		mainPage.clickAndTestAll();
		Thread.sleep(1000);
		
		List<String> list_1 = mainPage.elList(mainPage.InputColl());
//		for (String string : list_1) {
//			System.out.println(string);
//		}
		mainPage.LogOutButt.click();
		Thread.sleep(1000);
		mainPage.LogButt.click();
		Thread.sleep(3000);
		List<String> list_2 = mainPage.elList(mainPage.InputColl());
		
		Assert.assertTrue(list_1.equals(list_2));
		

	}

}
