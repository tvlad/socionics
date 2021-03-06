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
	
	@FindBy(css = ".team_strong.header_text.ng-binding")
	public WebElement TeamStrongAspectText;
	
	@FindBy(css = "div[id='charts_team1']")
	public WebElement RelationsVarietyGraph;
	
	@FindBy(css = ".modal-footer .btn.btn-primary")  // //button[contains(text(), 'OK')]
	public static WebElement AlertOK;
	
	@FindBy(xpath = "//button[contains(text(), 'Cancel')]")
	public WebElement AlertCancel;
	
	@FindBy(xpath = "//button[contains(text(), 'List view')]")
	public WebElement ListViewButton;
	
	@FindBy(xpath = "//button[contains(text(), 'Graph view')]")
	public WebElement GraphViewButton;
	
	@FindBy(css = ".info.person_selected  .name.ng-binding")
	public WebElement NameOnRightGraph;
	
	@FindBy(css = ".info.person_selected  .sociotype.ng-binding")
	public WebElement SocioOnRightGraph;
	
	@FindBy(css = ".btn.btn-warning > i")
	public WebElement AddPersonFromGraph;
	
	@FindBy(css = ".btn.btn-warning.test.dropdown-toggle.ng-binding")
	public WebElement detectButtonGraph;
	
	
	@FindBy(linkText = "Discover by myself")
	public WebElement TestLink;
	
//	-----------------------------------------------------------------------
	
	@FindBy(css = "div.person + div.relations.header_text.ng-binding")
	public WebElement RelationsVarietyHeader;
	
	@FindBy(css = "div.team_description.ng-binding + div.relations.header_text.ng-binding")
	public WebElement RelationsVarietyHeaderMain;
	
	@FindBy(css = "div#charts_person1 + div.personal_profile.header_text.ng-binding")
	public WebElement PersonalProfileHeader;
	
	@FindBy(css = "div#charts_person2 + div.header_text.ng-binding")
	public WebElement DescriptionHeader;
	
	@FindBy(css = ".top_fits.header_text.ng-binding")
	public WebElement TopFitsHeader;
	
	@FindBy(css = "div.fullName[style*='block']")
	public WebElement VisibleVertexPopUp;
	
	@FindBy(css = "div[id^='jsPlumb'][style*='block'] div.labelPer")
	public WebElement VisibleLinePopUp;
	
	@FindBy(css = ".label.ng-binding")
	public WebElement CompatibilityType;
	
	
//	.label.ng-binding
	
// ---------------------------------------------------------------------------
	
	public static List<WebElement> circleColl() { //
		return driver.findElements(By.cssSelector("div[id^='window']")); //
	}
	
	public static List<WebElement> circleDelColl() { //
		return driver.findElements(By.cssSelector("div[id^='window'] > i")); //
	}
	
//	.ng-pristine.ng-invalid.ng-invalid-required  input
	
	public List<WebElement> lineAllColl() { //
		return driver.findElements(By.cssSelector("._jsPlumb_connector path:nth-of-type(1)")); // div#container ._jsPlumb_connector     div#container path.hideA  ._jsPlumb_connector path:nth-of-type(1)
	}
	
	public List<WebElement> lineInvisibleColl() { //
		return driver.findElements(By.cssSelector("._jsPlumb_connector[style*='display: none'] path:nth-of-type(1)")); 
	}
	
	public List<WebElement> lineVisibleColl() { //
		return driver.findElements(By.cssSelector("._jsPlumb_connector[style*='display: block'] path:nth-of-type(1)")); 
	}
	
//	._jsPlumb_connector[style*='display: none'] path:nth-of-type(1)
	
	public List<WebElement> lineColl2() { //
		return driver.findElements(By.xpath("//*[@id='container']/svg[*]/path[1]")); // div#container ._jsPlumb_connector     div#container path.hideA
	}
	
	public List<WebElement> popUpColl() { //
		return driver.findElements(By.cssSelector("div.fullName")); //
	}
	
	public List<WebElement> inputFieldsColl() { //
		return driver.findElements(By.cssSelector(".ng-pristine.ng-invalid.ng-invalid-required  input")); //
	}
	
	public List<WebElement> DropDownPosition() { //
		return driver.findElements(By.cssSelector(".dropdown_line.ng-binding")); //
	}
	
	public List<WebElement> NameOnLineClickColl() { //
		return driver.findElements(By.cssSelector(".person_block  .name.ng-binding")); //
	}
	
	public List<WebElement> SociotypeOnLineClickColl() { //
		return driver.findElements(By.cssSelector(".person_block  .sociotype.ng-binding")); //
	}
	
	public List<WebElement> RelateRowColl() { // rows of relation graph
		return driver.findElements(By.cssSelector(".highcharts-series highcharts-tracker rect")); //("//g[1]/rect[*]")); //
	}
	
//	div#highcharts-32  g[1]/rect[*]
	
	
	public static void delAllPer() throws InterruptedException {
		int cyrcles = circleDelColl().size();
		while (cyrcles > 1) {

			Help.mouseOverHelp(circleColl().get(cyrcles - 1));
			circleDelColl().get(cyrcles - 1).click();
			Thread.sleep(1000);
			AlertOK.click();
			cyrcles = circleDelColl().size();

			Thread.sleep(1000);
		}
	}
	
//	return list of string
	public String[] textFromPopUp(WebElement el, WebElement elseEl) throws InterruptedException {
		Help.mouseOverHelp(el);
		String str = Help.noBr(elseEl.getText()); 	// get text from pop-up and delete //n-symbol
		String[] popUpText = Help.splitStr(str, ": ");
		return popUpText;
	}
	
//	return string
	public String srtingFromPopUp(WebElement el, WebElement elseEl) throws InterruptedException {
		Help.mouseOverHelp(el);
		String str = Help.noBr(elseEl.getText()); 	// get text from pop-up and delete //n-symbol
		return str;
	}

}
