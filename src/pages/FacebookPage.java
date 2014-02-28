package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {
private WebDriver driver;
	
	public FacebookPage(WebDriver _driver){
		driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	public WebElement EmailLog;
	
	@FindBy(id = "pass")
	public WebElement PassLog;
	
	@FindBy(name = "login")
	public WebElement LoginButt;

}
