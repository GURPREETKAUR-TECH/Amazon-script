package orderModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class YourOrders {
public static WebDriver driver;
	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
 driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.amazon.ca/");
		//Thread.sleep(13000);
Actions action=new Actions(driver);
		
		// mouse hover using 'Actions' class
action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();

// calling "signin" method
signin();

//mouse hover using 'Actions' class
action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).click().build().perform();

// click on 'my orders'
driver.findElement(By.xpath("//div[@data-card-identifier='YourOrders']")).click();

// click on order history dropdown
driver.findElement(By.cssSelector(".a-button.a-button-dropdown")).click();

//select "past 30 days" option
driver.findElement(By.xpath("(//ul[@tabindex='-1']/li/a)[1]")).click();

// message on the screen
String msg=driver.findElement(By.xpath("(//div[@id='ordersContainer']/div)[2]")).getText();

System.out.println(msg);

	
	
	
	
	
	
	}

	
	
	
	
	
	
	
	
	public static void signin() {
	      // enter email
			 driver.findElement(By.cssSelector("#ap_email")).sendKeys("gurpreetkaur114064@gmail.com");

			 // click on 'continue' button
			 driver.findElement(By.cssSelector("#continue")).click();
			 
			 // enter password
			 driver.findElement(By.id("ap_password")).sendKeys("Waheguru1@");
			 
			 // click on signin button
			 driver.findElement(By.id("auth-signin-button")).click();
			 
}
}