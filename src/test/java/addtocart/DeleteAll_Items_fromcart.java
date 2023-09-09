package addtocart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteAll_Items_fromcart {

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
	   	
	 // click on "add to cart" button (add wrist watch to cart)
	 	driver.findElement(By.id("add-to-cart-button")).click();
	 	
	 	// Click on add to cart icon on top right corner ( view cart)
	 	 driver.findElement(By.id("nav-cart-count")).click();
	 	 
	 	 
	 	// capture the subtotal of all products before any deletion
	 	String b=driver.findElement(By.xpath("//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-buybox sc-java-remote-feature']")).getText();
	 					
	 		System.out.println("before deletion "+b);
	 		
	 	// delete wrist watch item from add to cart page
	 	driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
	 	
	 	// to validate if wrist watch product is deleted from the cart
	 	boolean deleteditem= driver.findElement(By.xpath("//span[contains(text(),'Smart Watch, Fitness Tracker with Heart Rate Blood Oxygen')]")).isDisplayed();
	   if (deleteditem==true) {
		System.out.println("item is not deleted");
	}
	    else {
		System.out.println("item is deleted");
	}
		
		// capture the subtotal of all products after any deletion
		 	String a=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[5]/div/div[2]/div[1]/div/form/div[3]/span[2]/span")).getText();
		 					
		 		System.out.println("after deletion subtotal is  "+a);
	
        // to validate if cart is empty
		 String c=driver.findElement(By.xpath("//h1[normalize-space()='Your Amazon Cart is empty.']")).getText();
		 System.out.println(c);

	}

}
