package createAcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Partialmobilenum {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		Actions action=new Actions(driver);
		
		// mouse hover using 'Actions' class
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
	driver.findElement(By.linkText("Start here.")).click();
	driver.findElement(By.id("ap_customer_name")).sendKeys("gurpreet kaur");
	// mobile no. entered partially
	driver.findElement(By.id("ap_email")).sendKeys("467342");
	driver.findElement(By.id("ap_password")).sendKeys("123456");
	driver.findElement(By.id("ap_password_check")).sendKeys("123456");
	
	
	// clicking on "verify mobile no. " button
	driver.findElement(By.id("continue")).click();
	
	// User is navigated to 'Authentication page' , Printing title of page
	String s=driver.getTitle();
	System.out.println(s);
	
	

	}

}
