package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
//	To previous question
	
//	------------------------------------------------------------
	
	public static List<WebElement> TestButtColl() { //
		return driver.findElements(By.cssSelector(".btn.btn-warning.ng-scope.ng-binding")); // 
	}
	
	
//	------------------------------------------------------------
	
	public static void takeTest()  {
		WebElement fgh = driver.findElement(By.xpath("//*[@id='dc']/div/div[2]/div/span"));
		
		String nQ = Help.splitStr(fgh.getText(), " ")[3];
		
		System.out.println(nQ);
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

}
