package Tests_pro;

import java.util.concurrent.TimeUnit;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Selendroid {
		
	private WebDriver driver = null;

	  @Before
	  public void setup() throws Exception {
	    driver = new SelendroidDriver(new SelendroidCapabilities("android"));
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  }

	  @Test
	  public void assertEmployeeCanBeDisplayedWithDirects() throws Exception {
	    driver.get("https://www.google.com");
	    driver.switchTo().window("WEBVIEW");
	    
	    WebElement el = driver.findElement(By.cssSelector("#gs_tti0"));
	    WebElement hj = driver.findElement(By.name("btnG"));
	    el.sendKeys("sew");
	    hj.click();
	    WebElement vb = driver.findElement(By.id("resultStats"));
	    System.out.println("url - " + driver.getCurrentUrl() + " - " + driver.getTitle());
	    System.out.println("text - " + vb.getText());
	    // Switch to the web view context


	   Thread.sleep(4000);
	  }

	  @After
	  public void teardown() {
	    driver.quit();
	  }

}
