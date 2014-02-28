package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GraphPage {
	
private WebDriver driver;
	
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


//	
	
// ---------------------------------------------------------------------------
	
	public List<WebElement> circleColl() { //
		return driver.findElements(By.cssSelector("div[id^='window']")); //
	}

}
