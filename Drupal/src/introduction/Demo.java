package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/sukanya/Desktop/chromedriver33");
		WebDriver Driver = new ChromeDriver();
		
		Driver.get("http://localhost/drupal");
		System.out.println("home page loaded");
		Driver.findElement(By.id("edit-name")).sendKeys("admin");
		System.out.println("Entered Username");
		Driver.findElement(By.id("edit-pass")).sendKeys("admin");
		System.out.println("Entered Password");
		Driver.findElement(By.id("edit-submit")).click();
		System.out.println("Login successful");
		
		//Driver.findElement(By.xpath("//a[@href='/drupal/node/add']")).click();
		//System.out.println("Clicked on Add content");
		Driver.findElement(By.xpath("//a[@href='/drupal/node/5']")).click();
		System.out.println("Clicked on Product");
		Driver.findElement(By.id("edit-submit")).click();
		System.out.println("Added to cart");
		Driver.findElement(By.xpath("//a[@href='/drupal/cart']")).click();
		System.out.println("Clicked on shopping cart");
		String quantity = Driver.findElement(By.id("edit-edit-quantity-0")).getAttribute("value");
		System.out.println("old value :"+ quantity);
		int newQuantity = Integer.parseInt(quantity);
		newQuantity = newQuantity+1;
		System.out.println("new value :"+ newQuantity);
		Driver.findElement(By.id("edit-edit-quantity-0")).clear();
		Driver.findElement(By.id("edit-edit-quantity-0")).sendKeys(String.valueOf(newQuantity));
		Driver.findElement(By.xpath("//*[@value='Update cart']")).click();
		String updatedValue = Driver.findElement(By.id("edit-edit-quantity-0")).getAttribute("value");
		int updatedValue1 = Integer.parseInt(updatedValue);
		if(Integer.parseInt(quantity) < updatedValue1) {
			System.out.println("Cart updated");
		} else {
			System.out.println("Cart not updated");
		}
		Driver.findElement(By.xpath("//*[@value='Checkout']")).click();
		System.out.println("proceed to check");
		//System.out.println("value :"+1);
		//Driver.findElement(By.xpath("//a[@href='/drupal/node/5']")).click();
		//Driver.findElement(By.xpath("//a[@title='logout link']")).click();
		//System.out.println("User logged out");
		Driver.findElement(By.id("edit-customer-profile-billing-commerce-customer-address-und-0-name-line")).sendKeys("Arjun");
		Driver.findElement(By.id("edit-customer-profile-billing-commerce-customer-address-und-0-thoroughfare")).sendKeys("GordonRoad");
		Driver.findElement(By.id("edit-customer-profile-billing-commerce-customer-address-und-0-locality")).sendKeys("Fareham");	
		Driver.findElement(By.id("edit-customer-profile-billing-commerce-customer-address-und-0-postal-code")).sendKeys("p0167s9");
		Driver.findElement(By.id("edit-continue")).click();
		Driver.findElement(By.xpath("//*[@value='Continue to next step']")).click();
		Driver.findElement(By.id("createAccount")).click();
		Select dropdown= new Select(Driver.findElement(By.id("cardType")));
        dropdown.selectByIndex(3);
		System.out.println("proceed to check");
		Driver.findElement(By.id("cc")).sendKeys("4111111111111111");
		Driver.findElement(By.id("expiry_value")).sendKeys("12/22");
		Driver.findElement(By.id("cvv")).sendKeys("123");
		Driver.findElement(By.id("telephone")).sendKeys("7435412365");
		Driver.findElement(By.id("email")).sendKeys("ra@testuser.com");
		Driver.findElement(By.xpath("//*[@track-input='Pay_Now']")).click();
		
		
		
		
	}

}
