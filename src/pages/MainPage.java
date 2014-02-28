package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;






import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Main.Random;
import Main.WebDrInit;
import pages.FacebookPage;



public class MainPage {
	private static WebDriver driver;
	
	
	public MainPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*/header//button")
	public static WebElement LogButt;
	
	@FindBy(name = "name")
	public WebElement NameField;
	
	@FindBy(name = "email")
	public WebElement EMailField;
	
	@FindBy(linkText = "Detect")
	public WebElement TestButt;
	
	@FindBy(linkText = "Detect myself")
	public WebElement TestLink;
	
	@FindBy(xpath = "//*[@id='dc']/header/div/div/div/div/span")
	public WebElement LoginName;
	
	@FindBy(xpath = "//*/header//i")
	public static WebElement LogOutI;
	
	@FindBy(linkText = "Add new person")
	public static WebElement AddPerson;
	
	@FindBy(linkText = "Detect team chemistry score")
	public WebElement BuildGraph;
	
//	.//*[@id='dc']/div/div[2]/div/form/div/div[2]/ng-form[1]/div[4]/div[1]/div/ul/li[1]/a
//	.//*[@id='dc']/div/div[2]/div/form/div/div[2]/ng-form[2]/div[4]/div[2]/div/ul/li/a[1]
//	---------------------------------------------------------------
	// 
	
	public static List<WebElement> InputColl() { //
		return driver.findElements(By.xpath("//input")); // 
	}
	
	public List<WebElement> EmailColl() { //
		return driver.findElements(By.xpath(".//*[@id='dc']/div/div[2]/div/form/div/div[2]/ng-form[*]/div[2]/div/div/input")); // 
	}
	
	public List<WebElement> RoleColl() { //
		return driver.findElements(By.xpath("//*[@id='dc']/div/div[2]/div/form/div/div[2]/ng-form[*]/div[3]/div/div/input")); //
	}
	
	public List<WebElement> TestBut() { //
		return driver.findElements(By.linkText("Detect")); // //ng-form[*]/div[4]/div[1]/div/a
	}
	
	public List<WebElement> DelBut() { //
		return driver.findElements(By.cssSelector(".icon-remove-sign")); //
	}
	
	public List<WebElement> RoleFields() { //
		return driver.findElements(By.xpath("//*[@id='dc']//ng-form[*]/div[3]/div//input")); //
	}
	
	public List<WebElement> SocioLink() { //
		return driver.findElements(By.xpath("//a[contains(@class, 'btn btn-success dropdown-toggle icon ng-binding')]")); //
	}
	
	public List<WebElement> TestLink() { //
		return driver.findElements(By.xpath("//ng-form[*]/div[4]/div[1]/div/ul/li[4]/a[1]")); //
	}
//	//ng-form[*]/div[4]/div[1]/div/ul/li[4]/a[1]
	
//	------------------------------------------------------------------------------------------------

	
	public void logIn() throws InterruptedException {
		
		try {
			logInLogik(driver);
		} catch (NoSuchElementException e) {
			LogOutI.click();
			logInLogik(driver);
		}
		
	}
	
	public static void logInLogik(WebDriver driver) throws InterruptedException {
				
					
		//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
					
		LogButt.click();
		Thread.sleep(1000);
		
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		Thread.sleep(1000);
//		String newWindow = allWindows.find{ it != originalWindow };
					
		FacebookPage fbookPage = new FacebookPage(driver);
		
		fbookPage.EmailLog.sendKeys(WebDrInit.getLogin());
		fbookPage.PassLog.sendKeys(WebDrInit.getPass());
		fbookPage.LoginButt.click();
		
		//driver.switchTo().;
		Thread.sleep(1000);
		
		//Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
	}
	
//	-----------------------------------------------------------------------------------
	
	public static void inputPerson(int pNum) {
		for (int i = 0; i < pNum; i++) {
			List<WebElement> sdf = InputColl();

			if (sdf.size() == pNum * 3) {
				rDataInput();
			} else {
				rDataInput();
				AddPerson.click();
			}
		}
	}
	
	public static void rDataInput() {
		
		List<WebElement> sdf = InputColl();
		String name = Random.randomLogin() + " " + Random.randomLogin();
		String email = Random.randomEmail();
		String role = Random.randomLogin();
		sdf.get(sdf.size()-3).sendKeys(name);
		sdf.get(sdf.size()-2).sendKeys(email);
		sdf.get(sdf.size()-1).sendKeys(role);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void clickOnFirstDetect() {
		MainPage mainPage = new MainPage(driver);
		List<WebElement> sdf = mainPage.TestBut();
		sdf.get(0).click();
	}
	
	public void clickAndTestAll() {
		MainPage mainPage = new MainPage(driver);
		List<WebElement> sdf = mainPage.TestBut();
		
		for (int i = 0; i < sdf.size(); i++) {
			List<WebElement> sdf_2 = mainPage.TestBut();
			sdf_2.get(0).click();
			mainPage.TestLink.click();
			TestPage testPage = new TestPage(driver);
			@SuppressWarnings("unused")
			WebElement QNumg = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(testPage.QNum));
			TestPage.takeTest();
		}
	}

}

