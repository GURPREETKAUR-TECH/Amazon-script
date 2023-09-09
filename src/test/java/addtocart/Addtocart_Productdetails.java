package addtocart;

import java.time.Duration;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Addtocart_Productdetails {

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
		 
		 //Thread.sleep(8000);
		 
		 // searching for "wrist watch" in search box
	   		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wrist watch");
	   					
	   		// click on search button
	   		driver.findElement(By.id("nav-search-submit-button")).click();
	   				
	   		Thread.sleep(7000);

	   	// click on one of the product
	   	
	   	driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/descendant::span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Smart Watch, Fitness Tracker with Heart Rate Blood')]")).click();
	   	
	   	Thread.sleep(10000);
	   	
	  // capturing title of page before adding product to cart 	
	 String a=  driver.getTitle();
	 System.out.println(a);
	   	
	 // click on "add to cart" button (add wrist watch to cart)
	 	driver.findElement(By.id("add-to-cart-button")).click();
	 	
	 	// Click on add to cart icon on top right corner ( view cart)
	 	 driver.findElement(By.id("nav-cart-count")).click();
	 	 
	 	 Thread.sleep(8000);
	 	//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", click);
	 	 
      // click on product that is added to cart
	 	WebElement click=driver.findElement(By.xpath("//span[contains(text(),'Smart Watch, Fitness Tracker with Heart Rate Blood Oxygen')]"));
	 	JavascriptExecutor js=(JavascriptExecutor)driver;
	 	js.executeScript("arguments[0].click();", click);
	 	
	 	Thread.sleep(5000);
	 	
	 	Set<String> windows=driver.getWindowHandles();
	 	Iterator<String> it=windows.iterator();
	 	String parentid=it.next();
	 	String childid=it.next();
	 	
	 	driver.switchTo().window(childid);
	 	
	 	
	 // capturing title of page after clicking on the product from "add to cart" page	
		 String b=  driver.getTitle();
		 System.out.println(b);

	if ( a.equalsIgnoreCase(b)) {
		System.out.println("test is passed");
	}
	else {
		System.out.println("test is failed");
	}
	}

}
