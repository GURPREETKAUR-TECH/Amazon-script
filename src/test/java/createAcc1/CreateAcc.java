package createAcc1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateAcc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		Actions action=new Actions(driver);
		
		// Hover mouse using 'Actions' class
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	driver.findElement(By.linkText("Start here.")).click();
	driver.findElement(By.id("ap_password")).sendKeys("123456");
	driver.findElement(By.id("ap_password_check")).sendKeys("123456");
	driver.findElement(By.id("continue")).click();
	
	//'Name' field is left blank , Printing error message in console
	String nameErrorMsg=driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]")).getText();
	System.out.println(nameErrorMsg);
	
	//'email or mobile number' field is left blank , Printing error message in console
	String mobilenumberOremailErrorMsg=driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).getText();
	System.out.println(mobilenumberOremailErrorMsg);
	
	driver.findElement(By.id("ap_customer_name")).sendKeys("gurpreet kaur");
	// mobile no. entered partially
	driver.findElement(By.id("ap_email")).sendKeys("467342");
	driver.findElement(By.id("ap_password")).sendKeys("123456");
	driver.findElement(By.id("ap_password_check")).sendKeys("123456");
	
	// clicking on "verify mobile no. " button
	driver.findElement(By.id("continue")).click();
	
	// Printing the error message for partial mobile no.
	String mobilenoPartial=driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
	System.out.println(mobilenoPartial);
	
	
	
	
	}

}
