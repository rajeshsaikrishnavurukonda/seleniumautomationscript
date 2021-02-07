package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class google {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/sukanya/Desktop/chromedriver33");
		WebDriver Driver = new ChromeDriver();
		Driver.get("https://www.google.com");
		Driver.switchTo().frame(Driver.findElement(By.xpath("/html/body/div/div[4]/div[3]/div/div[2]/span/div/div/iframe")));
		Driver.findElement(By.xpath("/html/body/div/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span")).click();
		Driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("performance testing");
		Driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input")).submit();
		Driver.close();
	}

}
