package addtocart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class New {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.ca/");
		Thread.sleep(13000);
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
			// capture the name of selected product before adding to cart
			 String namebeforecart=driver.findElement(By.id("productTitle")).getText();
			 System.out.println(namebeforecart);
			 
			// capture the price of selected product before adding to cart
			 String pricebeforecart= driver.findElement(By.xpath("//form[@method='post']//div[@data-feature-name='apex_offerDisplay_desktop']//div//span[contains(text(),'$16.99')]")).getText();
			 System.out.println(pricebeforecart);
			 
			// capture the image of selected product before adding to cart
			 driver.findElement(By.xpath("//img[@alt='Shuttle Art Highlighters, 15 Colors Pastel Highlighter Pens Assorted Colors, Chisel Tip Dry-Quickly Non-Toxic Highlighter Markers for Adults Kids Highlighting in the Home School Office']"));
			
			// click on "add to cart" button
			 driver.findElement(By.id("add-to-cart-button")).click();
			 
			// Click on add to cart icon on top right corner
			 driver.findElement(By.id("nav-cart-count")).click();
	
			// capture the name of selected product after adding to cart
			 String nameaftercart=driver.findElement(By.xpath("//span[@aria-hidden='true'][contains(text(),'Shuttle Art Highlighters, 15 Colors Pastel Highlig')]")).getText();
			 System.out.println(nameaftercart);
			 
			// capture the price of selected product after adding to cart
			 String priceaftercart= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).getText();
			 System.out.println(priceaftercart); //span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']
			 
			// capture the image of selected product after adding to cart
			 driver.findElement(By.xpath("//img[@alt='Shuttle Art Highlighters, 15 Colors Pastel Highlighter Pens Assorted Colors, Chisel Tip Dry-Quickly Non-Toxic Highlighter Markers for Adults Kids Highlighting in the Home School Office, Opens in a new tab']"));
		
			 if(namebeforecart.contains("Shuttle Art Highlighters, 15 Colors Pastel Highlighter Pens")) {
				 System.out.println(" name test is passed");
			 }
			 else {
				 System.out.println(" name test is failed");
			 }
			 
			 if(priceaftercart.equalsIgnoreCase("$16.99")) {
				 System.out.println(" price test is passed");
			 }
			 else {
				 System.out.println(" price test is failed");
			 }
			 
			
	}

}
