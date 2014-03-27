package Main;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pages.MainPage;
import pages.TestPage;
import pages.TestResultPage;



public class WebDrInit {
	
	/*
	 * Class of webdriver initialization.
	 * 
	 */
	
	protected static WebDriver driver; 
	public static String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
//	private pages.LogInPage logInPage;
	public WebDriverWait wait;
	private static String browser = null; // firefox // Variable to determine the browser.
	protected static String Login;
	protected static String Password;
	protected static String fileName = "";
	
	@BeforeSuite
	public void setFN(){
	fileName = "my-logs/log-" + Help.CurDateString() + ".txt";
	}
		
	@BeforeClass
	public void setUp() throws IOException {
		
		
		browser = setBrowser();
				
		switch (browser) {
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			driver = new ChromeDriver();
			break;
		default:
			driver = new FirefoxDriver();
//			break;
		}


		
		Login =  DataProv.prop("Login");
		Password = DataProv.prop("Password");

		baseUrl = DataProv.prop("baseUrl");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
//		driver.manage().deleteAllCookies();
		
		MainPage mainpage = new MainPage(driver); //for IE case
		if (mainpage.LoginName.isDisplayed()){
			MainPage.LogOutButt.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		

	
	@AfterClass
	public void tearDown() throws Exception {
//		driver.close();
//		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}
	
	public static String getBrowser() {
		return browser;
	}
	
//	?
	public static String setBrowser() {
		browser = DataProv.prop("browser");
		return browser;
	}
	// 
	
	public static String getLogin() {
		Login = DataProv.prop("Login");
		return Login;
	}
	
	public static String getPass() {
		Login = DataProv.prop("Password");
		return Password;
	}
	
	
	public static String getfileName() {
		return fileName;
	}

	public static WebDriver getDriver() {
		WebDriver driver_ = driver;
		return driver_;
	}
	
//	----------------------------------------------------
	


	public static void takeTest(WebElement el) throws IOException,
			InterruptedException {

		MainPage mainPage = new MainPage(driver);
		el.click();
		mainPage.TestLink.click();

		
		WebElement QNum = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOf(TestPage.QNum));

		List<WebElement> testButt = TestPage.TestButtColl();
		String nQ = Help.splitStr(QNum.getText(), " ")[3];
//		System.out.println("integr - " + Integer.parseInt(nQ));
		for (int i = 0; i < Integer.parseInt(nQ); i++) {
//			Thread.sleep(1000);
			testButt.get(Random.rInt()).click();
			
		}

		TestResultPage testResultPage = new TestResultPage(driver);

		@SuppressWarnings("unused")
		WebElement sociotype = new WebDriverWait(driver, 10)
				.until(ExpectedConditions
						.visibilityOf(testResultPage.DefinedSociotype));

		testResultPage.GoToTeam.click();

	}
	
//	public static void mouseOver(WebElement el) {
//		Actions builder = new Actions(driver);
//		Action move = builder.moveToElement(el).build();
//		move.perform();
//	}
}
