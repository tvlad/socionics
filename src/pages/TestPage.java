package pages;


import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Main.Help;
import Main.Random;

public class TestPage {
	
	private static WebDriver driver;
	
	public TestPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id='dc']/div/div[2]/div/span")
	public static WebElement QNum;
	
	@FindBy(linkText = "To previous question")
	public WebElement ToPrevLink;
	
	@FindBy(linkText = "To next question")
	public WebElement ToNextLink;
	
	@FindBy(xpath = "//header/div/div/div/div[1]/div[2]/div")
	public WebElement WarningPopUp;
	
	
	
//	//header/div/div/div/div[1]/div[2]/div
	
//	------------------------------------------------------------
	
	public static List<WebElement> TestButtColl() { //
		return driver.findElements(By.cssSelector(".btn.btn-warning.ng-scope.ng-binding")); // 
	}
	
	
//	------------------------------------------------------------
	
	public static void takeTest()  {

		
		String nQ = Help.splitStr(QNum.getText(), " ")[3];
		
//		System.out.println(nQ);
		// System.out.println("integr - " + Integer.parseInt(nQ));
		for (int i = 0; i < Integer.parseInt(nQ); i++) {
			// Thread.sleep(1000);
			TestButtColl().get(Random.rInt()).click();
		}
		
		TestResultPage testResultPage = new TestResultPage(driver);

		@SuppressWarnings("unused")
		WebElement sociotype = new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOf(testResultPage.DefinedSociotype));

		testResultPage.GoToTeam.click();
	}
	
	public static void takeTestWithOutReturn()  {

		
		String nQ = Help.splitStr(QNum.getText(), " ")[3];
		
//		System.out.println(nQ);
		// System.out.println("integr - " + Integer.parseInt(nQ));
		for (int i = 0; i < Integer.parseInt(nQ); i++) {
			// Thread.sleep(1000);
			TestButtColl().get(Random.rInt()).click();
		}
		
		TestResultPage testResultPage = new TestResultPage(driver);

		@SuppressWarnings("unused")
		WebElement sociotype = new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOf(testResultPage.DefinedSociotype));


	}

}
