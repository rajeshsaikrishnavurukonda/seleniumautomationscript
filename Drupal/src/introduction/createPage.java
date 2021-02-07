package introduction;

import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;

import components.chrome;

public class createPage extends chrome {

	public static void main(String[] args) {
		chrome defaults = new chrome();
		defaults.initialize();
		try {
		defaults.login(null, "rajesh", "rajesh");
		defaults.getDriver().findElement(By.xpath("//*[@href='/drupal/admin/content']")).click();
		defaults.createPage("Hello", "this is my first automation page");
		} catch (NoSuchElementException e) {
			System.out.println("WebDriver could not locate the element");
		}
	}
}
