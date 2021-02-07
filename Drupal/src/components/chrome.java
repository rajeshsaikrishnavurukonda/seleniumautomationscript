package components;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class chrome {

	public WebDriver Driver;
	
	public void setDriver() {
		this.Driver = new ChromeDriver();
	}
	
	public WebDriver getDriver() {
		if(this.Driver == null) {
			this.setDriver();
			System.out.println("Driver initialized");
		} else {
			//System.out.println("Driver already initialized");
		}
		return this.Driver;
	}

	public void initialize() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/sukanya/Desktop/chromedriver33");
		this.getDriver();
		Driver.get("http://localhost/drupal");
		System.out.println("home page loaded");
		
	}
	
	public void login(WebDriver Driver, String username, String pass) {
		if(Driver == null) {
			Driver = this.getDriver();
		}
		Driver.findElement(By.id("edit-name")).sendKeys(username);
		System.out.println("Username :" + username);
		Driver.findElement(By.id("edit-pass")).sendKeys(pass);
		System.out.println("Password : ******" );
		Driver.findElement(By.id("edit-submit")).click();
		System.out.println("Login successful");
	}
	
	public String parentWindow() {
    	String parentWindowHandler = this.getDriver().getWindowHandle();
    	return parentWindowHandler;
	}
	
    public void handleChildWindows() {
		String subWindowHandler = null;
		Set<String> handles = this.getDriver().getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		this.getDriver().switchTo().window(subWindowHandler);
    }
    
    public void switchToiFrame(String xpath) {
    	this.getDriver().switchTo().frame(this.getDriver().findElement(By.xpath(xpath)));
    }
    
    public void createPage(String title, String desc) {
    	WebDriver Driver = this.getDriver();
    	this.handleChildWindows();
		this.switchToiFrame("/html/body/div[4]/iframe[2]");
		Driver.findElement(By.xpath("//a[@href='/drupal/node/add']")).click();
		this.handleChildWindows();
		this.switchToiFrame("/html/body/div[4]/iframe[1]");
		Driver.findElement(By.xpath("//a[@href='/drupal/node/add/page']")).click();
		this.handleChildWindows();
		this.switchToiFrame("/html/body/div[4]/iframe[2]");
    	Driver.findElement(By.id("edit-title")).sendKeys(title);
    	Driver.findElement(By.id("edit-body-und-0-value")).sendKeys(desc);
    	Driver.findElement(By.id("edit-submit")).click();
    	String message = Driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div")).getText();
    	System.out.println(message);
    	Driver.close();
    }
}
