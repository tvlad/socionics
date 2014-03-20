package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Main.Help;

public class GraphPage {
	
private static WebDriver driver;
	
	public GraphPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".dropdown-toggle.btn.btn-success")
	public WebElement DropDownAll;
	
	@FindBy(css = ".value")
	public WebElement persentOfRel;
	
	@FindBy(css = "div.value + div + div")
	public WebElement RelationsVarietyText;
	
	@FindBy(css = ".team_strong.header_text.ng-binding")
	public WebElement TeamStrongAspectText;
	
	@FindBy(css = "div[id='charts_team1']")
	public WebElement RelationsVarietyGraph;
	
	@FindBy(xpath = "//button[contains(text(), 'OK')]")
	public static WebElement AlertOK;
	
	@FindBy(xpath = "//button[contains(text(), 'Cancel')]")
	public WebElement AlertCancel;
	
	@FindBy(xpath = "//button[contains(text(), 'List view')]")
	public WebElement ListViewButton;
	
	@FindBy(xpath = "//button[contains(text(), 'Graph view')]")
	public WebElement GraphViewButton;
	
	@FindBy(xpath = "//div[2]/div[3]/div[1]/div[1]")
	public WebElement NameOnRightGraph;
	
	@FindBy(xpath = "//div[3]/div[1]/div[2]")
	public WebElement SocioOnRightGraph;
	
	@FindBy(css = ".btn.btn-warning > i")
	public WebElement AddPersonFromGraph;


//	List view . Add new person 
	
// ---------------------------------------------------------------------------
	
	public static List<WebElement> circleColl() { //
		return driver.findElements(By.cssSelector("div[id^='window']")); //
	}
	
	public static List<WebElement> circleDelColl() { //
		return driver.findElements(By.cssSelector("div[id^='window'] > i")); //
	}
	
//	div.fullName  #window200 > i.icon-remove-sign
	
	public List<WebElement> lineColl() { //
		return driver.findElements(By.cssSelector("div#container path")); //
	}
	
	public List<WebElement> popUpColl() { //
		return driver.findElements(By.cssSelector("div.fullName")); //
	}
	
	
	public static void delAllPer() throws InterruptedException {
		int cyrcles = circleDelColl().size();
		while ( cyrcles > 1){
			
			Help.mouseOverHelp(circleColl().get(cyrcles-1));
			circleDelColl().get(cyrcles-1).click();
			AlertOK.click();
			cyrcles = circleDelColl().size();
			
			Thread.sleep(1000);
		}
		
		
		
		
	}

}
