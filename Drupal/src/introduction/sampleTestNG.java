package introduction;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.Assert;

public class NewTest {
	
  public WebDriver Driver;
  
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","/Users/sukanya/Desktop/chromedriver33");
		this.Driver = new ChromeDriver();
		Driver.get("https://www.esteelauder.fr");
  }
  
  @Test(priority=0)
  public void comparePageTitle() {
	    WebDriver Driver = this.Driver;
	    String pageTitle = Driver.getTitle();
	    String ourTitle = "Estée Lauder | Maquillage, Soin, Parfum";
	    Assert.assertEquals(ourTitle, pageTitle);

  }
  /*@Test(priority=1)
  public void searchUsername() {
	  this.Driver.findElement(By.xpath("//[@data-test-id='username']"));
  }*/

  @AfterClass
  public void afterClass() {
	 this.Driver.close();
  }

}
