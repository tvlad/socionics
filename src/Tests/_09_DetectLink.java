package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.MainPage;
import Main.WebDrInit;

public class _09_DetectLink extends WebDrInit{
	
	/*
	 * Verify links in pop-up into 'Detect' 
	 */
	
	@SuppressWarnings("static-access")
	@Test(groups = "mainPage")
	public void _09_T_DetectLink() throws InterruptedException  {
		MainPage mainPage = new MainPage(driver);
		mainPage.AddPerson.click();
		mainPage.DetectButt().get(0).click();
		Thread.sleep(500);
		Assert.assertEquals(mainPage.TestLinkColl().get(0).getText(), "Discover my profile");		
		
		mainPage.DetectButt().get(1).click();
		
		Assert.assertEquals(mainPage.TestLinkColl().get(1).getText(), "Discover by myself");
		Assert.assertEquals(mainPage.InvateLink.getText(), "Invite person to detect");
		
		
	}

}
