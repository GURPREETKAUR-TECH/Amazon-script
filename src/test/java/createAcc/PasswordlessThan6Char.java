package createAcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PasswordlessThan6Char {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		Actions action=new Actions(driver);
		
		// mouse hover using 'Actions' class
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	driver.findElement(By.linkText("Start here.")).click();
	driver.findElement(By.id("ap_customer_name")).sendKeys("gurpreet kaur");
	driver.findElement(By.id("ap_email")).sendKeys("rabiakaur@gmail.com");
	
	// Entered less than 6 characters password
	driver.findElement(By.id("ap_password")).sendKeys("123");
	driver.findElement(By.id("ap_password_check")).sendKeys("123");
	
	
	// clicking on "verify email " button
	driver.findElement(By.id("continue")).click();
	
	// Printing error message in console
		String errormsg = driver.findElement(By.xpath("(//div[@class='a-alert-content'][normalize-space()='Minimum 6 characters required'])[2]")).getText();
		System.out.println(errormsg);

	}

}
