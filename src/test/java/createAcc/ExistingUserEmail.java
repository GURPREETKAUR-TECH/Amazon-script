package createAcc;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExistingUserEmail {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.ca/");
	Actions action=new Actions(driver);
		
// mouse hover using 'Actions' class
action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();// TODO Auto-generated method stub
   // Clicking on sign in button
driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")).click();
	
// entering wrong email
driver.findElement(By.id("ap_email")).sendKeys("ekjot@");
driver.findElement(By.id("continue")).click();

// Printing error message
 String errormsg=driver.findElement(By.xpath("//span[contains(text(),'We cannot find an account with that e')]")).getText();
 System.out.println(errormsg);
	
	}

}
