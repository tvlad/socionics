package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestResultPage {
	
private WebDriver driver;
	
	public TestResultPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a/span[2]")
	public WebElement GoToTeam;
	
//	
	
	@FindBy(xpath = "//*[@id='dc']/div/div[2]/div/div[2]/span[2]") // //*[@id='dc']/div/div[2]/div/div[2]/span[2]
	public WebElement DefinedSociotype;

}
