package pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;






import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Main.DataProv;
import Main.Random;
import Main.WebDrInit;
import pages.FacebookPage;



public class MainPage {
	private static WebDriver driver;
	
	
	public MainPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//header//button")
	public static WebElement LogButt;
	
	@FindBy(css = ".icon-logout.btn-logout")
	public static WebElement LogOutButt;
	
//	.icon-logout.btn-logout
	
	@FindBy(name = "name")
	public WebElement NameField;
	
	@FindBy(name = "email")
	public WebElement EMailField;
	
	@FindBy(linkText = "Detect")
	public WebElement TestButt;
	
	@FindBy(linkText = "Discover by myself")
	public WebElement TestLink;
	
	@FindBy(linkText = "Invite person to detect")
	public WebElement InvateLink;
	
	@FindBy(xpath = "//*[@id='dc']/header/div/div/div/div/span")
	public WebElement LoginName;
	
	@FindBy(xpath = "//*/header//i")
	public static WebElement LogOutI;
	
	@FindBy(xpath = "//button[contains(text(),'Profile your peer')]")
	public static  WebElement AddPerson;
	
	@FindBy(xpath = "//button[contains(text(),'Detect team chemistry score')]")
	public WebElement BuildGraph;
	
	@FindBy(xpath = "//ng-form[*]/div[3]/div/div/ul/li/a")
	public WebElement TextForRole;
	
	@FindBy(xpath = "//div[@class='send-config']/div[@class='popover top fade in']")
	public WebElement DetectScorePopUp;
	
	
//	
//	---------------------------------------------------------------
	// 
	
	public static List<WebElement> InputColl() { //
		return driver.findElements(By.xpath("//input")); // 
	}
	
	public static List<WebElement> DetectButt() { //
		return driver.findElements(By.linkText("Detect")); // //ng-form[*]/div[4]/div[1]/div/a
	}
	
	public static List<WebElement> UnDetectButt() { //
		return driver.findElements(By.xpath("//div[@class='dropdown']/a[string-length() = 3]")); // 
	}
	
	public static List<WebElement> AllButt() { //
		return driver.findElements(By.xpath("//ng-form[*]/div[4]/div[1]/div/a")); // 
	}
	
	
	//
	
		
	public static List<WebElement> EmailColl() { //
		return driver.findElements(By.xpath(".//*[@id='dc']/div/div[2]/div/form/div/div[2]/ng-form[*]/div[2]/div/div/input")); // 
	}
	
	public List<WebElement> RoleColl() { //
		return driver.findElements(By.xpath("//*[@id='dc']/div/div[2]/div/form/div/div[2]/ng-form[*]/div[3]/div/div/input")); //
	}
	
	
	
	public List<WebElement> DeleteButton() { //
		return driver.findElements(By.cssSelector(".icon-remove-sign")); //
	}
	
	public List<WebElement> RoleFields() { //
		return driver.findElements(By.xpath("//*[@id='dc']//ng-form[*]/div[3]/div//input")); //
	}
	
	public List<WebElement> SocioLink() { //
		return driver.findElements(By.xpath("//a[contains(@class, 'btn btn-success dropdown-toggle icon ng-binding')]")); //
	}
	
	public List<WebElement> TestLinkColl() { //
		return driver.findElements(By.xpath("//ng-form[*]/div[4]/div[2]/div/ul/li/a[1]")); //
	}
	
	public List<WebElement> DeleteColl() { //
		return driver.findElements(By.cssSelector(".icon-remove-sign")); //
	}
	
	public List<WebElement> RequiredColl() { //
		return driver.findElements(By.xpath("//ng-form[*]/div[1]/div/div/span")); //
	}
	
	public List<WebElement> MailWarningColl() { //
		return driver.findElements(By.xpath("//ng-form[*]/div[2]/div/div/span[1]")); //
	}
	
	
	
	
	
	// //ng-form[*]/div[4]/div[2]/div/ul/li/a[1]
	
//	// //ng-form[*]/div[4]/div[2]/div/ul/li/a[1]
	
//	------------------------------------------------------------------------------------------------

	
	public void logIn() throws InterruptedException {
		Thread.sleep(500);
		try {
			logInLogik(driver);
		} catch (NoSuchElementException e) {
			LogOutI.click();
			logInLogik(driver);
		}
		
		catch (ElementNotVisibleException b){
			LogOutI.click();
			logInLogik(driver);
		}
		
		Thread.sleep(500);
	}
	
	public static void logInLogik(WebDriver driver) throws InterruptedException {
				
					
		//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
					
		LogButt.click();
		Thread.sleep(500);
		
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}

		Thread.sleep(500);
//		String newWindow = allWindows.find{ it != originalWindow };
					
		FacebookPage fbookPage = new FacebookPage(driver);
		
		fbookPage.EmailLog.clear();
		fbookPage.EmailLog.sendKeys(WebDrInit.getLogin());
		fbookPage.PassLog.sendKeys(WebDrInit.getPass());
		fbookPage.LoginButt.click();
		
		//driver.switchTo().;
		Thread.sleep(500);
		
		//Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		
	}
	
//	-----------------------------------------------------------------------------------
	
	@SuppressWarnings("static-access")
	public static void inputPerson(int pNum) {
		MainPage mainPage = new MainPage(driver);
		int fg = mainPage.InputColl().size() - 3;

		String fgfh = mainPage.InputColl().get(fg).getAttribute("value");

		if (fgfh.equals("")) {

		} else {
			AddPerson.click();
		}

		for (int i = 0; i < pNum; i++) {

			if (i == pNum - 1) {
				rDataInput();
			} else {
				rDataInput();
				AddPerson.click();
			}
		}
	}


	
	public static void rDataInput() {
		
		List<WebElement> Input = InputColl();
		
		
		String name = Random.randomLogin() + " " + Random.randomLogin();
		String email = Random.randomEmail();
		String role = Random.randomLogin();
		Input.get(Input.size()-3).sendKeys(name);
		Input.get(Input.size()-2).sendKeys(email);
		Input.get(Input.size()-1).sendKeys(role);
		
	}
	
	public void clickOnFirstDetect() {
		MainPage mainPage = new MainPage(driver);
		@SuppressWarnings("static-access")
		List<WebElement> sdf = mainPage.DetectButt();
		sdf.get(0).click();
	}
	
	@SuppressWarnings({ "static-access", "unused" })
	public void clickAndTestAll() {
		MainPage mainPage = new MainPage(driver);

		List<WebElement> sdf = mainPage.DetectButt();
		List<WebElement> cvb = mainPage.AllButt();

		for (int i = 0; i < sdf.size(); i++) {

			List<WebElement> sdf_2 = mainPage.DetectButt();
			sdf_2.get(0).click();
			// проверяет не произошел ли переход на тестовую страницу
			if (DataProv.prop("baseUrl").equals(driver.getCurrentUrl())) {
				mainPage.TestLinkColl().get(i + (cvb.size() - sdf.size())).click();
			}
			
			TestPage testPage = new TestPage(driver);
			
			WebElement QNumg = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(testPage.QNum));
			TestPage.takeTest();
			
				
		}
		
	}
	
	
	public List<String> elList(List<WebElement> elements) {
		List<String> list = new ArrayList<String>();
		for (WebElement el : elements) {
			list.add(el.getAttribute("value"));
		}
		
		return list;
	}
	
	

		
	

}
