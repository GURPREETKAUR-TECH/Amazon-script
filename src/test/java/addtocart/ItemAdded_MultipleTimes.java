package addtocart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ItemAdded_MultipleTimes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.ca/");
		//Thread.sleep(13000);
		Actions action=new Actions(driver);
		
		// mouse hover using 'Actions' class
		action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		driver.findElement(By.xpath("//span[@class='nav-action-inner']")).click();	
		 // enter email
		 driver.findElement(By.cssSelector("#ap_email")).sendKeys("gurpreetkaur114064@gmail.com");

		 // click on 'continue' button
		 driver.findElement(By.cssSelector("#continue")).click();
		 
		 // enter password
		 driver.findElement(By.id("ap_password")).sendKeys("Waheguru1@");
		 
		 // click on signin button
		 driver.findElement(By.id("auth-signin-button")).click();
		 
		 Thread.sleep(8000);
		 
		// searching for "liner highlighter" in search box
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("liner highlighter");
				
			// click on search button
			driver.findElement(By.id("nav-search-submit-button")).click();
			
			Thread.sleep(7000);
			// click on one of the product
		WebElement click=	driver.findElement(By.xpath("//div[@data-component-type='s-impression-counter']//div//div//div//div//span[contains(text(),'Shuttle Art Highlighters, 15 Colors Pastel Highlig')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", click);	
			Thread.sleep(10000); 
			
			// click on "add to cart" button
			 driver.findElement(By.id("add-to-cart-button")).click();
			 
		// navigate back to previous page 
		driver.navigate().back();
		
		// click on "add to cart" button to again add the product to cart
		 driver.findElement(By.id("add-to-cart-button")).click();
		 
		// Click on add to cart icon on top right corner
		 driver.findElement(By.id("nav-cart-count")).click();
		 
		
	// capture the subtotal of all quantity added
	String b=driver.findElement(By.xpath("//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-buybox sc-java-remote-feature']")).getText();
			
	System.out.println( b);
		
	}

}
