package addtocart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Add_DifferentProduct {

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
		
			// capture the name of selected product(liner highlighter) before adding to cart
			 String name1beforecart=driver.findElement(By.id("productTitle")).getText();
			 System.out.println("name1 is "+name1beforecart);
			 // //form[@method='post']//div[@data-feature-name='apex_offerDisplay_desktop']//div//span[contains(text(),'$16.99')]
			
			 // capture the price of selected product(liner highlighter) before adding to cart
			 String price1beforecart= driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[4]/div[4]/div[10]/div/div[1]/div[3]/div[1]/span[1]/span[1]")).getText();
			 System.out.println("price1 is "+price1beforecart);
			 
			// capture the image of selected product(liner highlighter) before adding to cart
			 driver.findElement(By.xpath("//img[@alt='Shuttle Art Highlighters, 15 Colors Pastel Highlighter Pens Assorted Colors, Chisel Tip Dry-Quickly Non-Toxic Highlighter Markers for Adults Kids Highlighting in the Home School Office']"));
			
	  // click on "add to cart" button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		// Click on add to cart icon on top right corner ( view cart)
		 driver.findElement(By.id("nav-cart-count")).click();
		 
		// capture the name of selected product(liner highlighter) after adding to cart
		 String name1aftercart=driver.findElement(By.xpath("//span[@aria-hidden='true'][contains(text(),'Shuttle Art Highlighters, 15 Colors Pastel Highlig')]")).getText();
		 System.out.println("name1 after cart is "+name1aftercart);
		 
		// capture the price of selected product(liner highlighter) after adding to cart
		 String price1aftercart= driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).getText();
		 System.out.println("price1 after cart is "+price1aftercart); //span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']
		 
		// capture the image of selected product after(liner highlighter) adding to cart
		 driver.findElement(By.xpath("//img[@alt='Shuttle Art Highlighters, 15 Colors Pastel Highlighter Pens Assorted Colors, Chisel Tip Dry-Quickly Non-Toxic Highlighter Markers for Adults Kids Highlighting in the Home School Office, Opens in a new tab']"));
		 
		 if(name1beforecart.contains("Shuttle Art Highlighters, 15 Colors Pastel Highlighter Pens")) {
			 System.out.println(" name test is passed");
		 }
		 else {
			 System.out.println(" name test is failed");
		 }
		 
		 if(price1aftercart.equalsIgnoreCase("$16.99")) {
			 System.out.println(" price test is passed");
		 }
		 else {
			 System.out.println(" price test is failed");
		 }
	
		// searching for "wrist watch" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wrist watch");
					
		// click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
				
		Thread.sleep(7000);

	// click on one of the product
	
	driver.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/descendant::span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Smart Watch, Fitness Tracker with Heart Rate Blood')]")).click();
	
	Thread.sleep(10000);
	
	// capture the name of selected product(wrist watch) before adding to cart
	 String name2beforecart=driver.findElement(By.id("productTitle")).getText();
	 System.out.println("name2 is "+name2beforecart);
	 
	// capture the price of selected product(wrist watch) before adding to cart
	 String price2beforecart= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none aok-align-center']/descendant::span[@class='a-offscreen'][contains(text(),'$47.99')])[2]")).getText();
	 System.out.println("price2 is "+price2beforecart);
	 
	// capture the image of selected product(wrist watch) before adding to cart
	// driver.findElement(By.cssSelector("img[src='https://m.media-amazon.com/images/I/81RGoVmuqAL._AC_SX425_.jpg']"));
	
	 // click on "add to cart" button (add wrist watch to cart)
	driver.findElement(By.id("add-to-cart-button")).click();
	
	// Click on add to cart icon on top right corner ( view cart)
	 driver.findElement(By.id("nav-cart-count")).click();
	 
	
	 
	// capture the name of selected product(wrist watch) after adding to cart
		 String name2aftercart=driver.findElement(By.xpath("//span[contains(text(),'Smart Watch, Fitness Tracker with Heart Rate Blood Oxygen')]")).getText();
		 System.out.println("name2 after cart is "+name2aftercart);
		 
		// capture the price of selected product(wrist watch) after adding to cart
		 String price2aftercart= driver.findElement(By.xpath("//p[@class='a-spacing-mini']//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'][contains(text(),'$47.99')]")).getText();
		 System.out.println("price2 after cart is "+price2aftercart); //span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']
		 
		// capture the image of selected product after(wrist watch) adding to cart
		 driver.findElement(By.xpath("//img[@alt='Smart Watch, Fitness Tracker with Heart Rate Blood Oxygen Sleep Monitor, 1.7\" DIY Full Touch Screen Smartwatch for Women Men,Waterproof Fitness Watch for iPhone Android Phones (Pink), Opens in a new tab']"));
		 
		 if(name2beforecart.contains("Smart Watch, Fitness Tracker with Heart Rate Blood Oxygen")) {
			 System.out.println(" name2 test is passed");
		 }
		 else {
			 System.out.println(" name2 test is failed");
		 }
		 
		 if(price2aftercart.equalsIgnoreCase("$47.99")) {
			 System.out.println(" price2 test is passed");
		 }
		 else {
			 System.out.println(" price2 test is failed");
		 }
	
	// capture the subtotal of all quantity added
	String b=driver.findElement(By.xpath("//div[@class='a-row a-spacing-mini sc-subtotal sc-subtotal-buybox sc-java-remote-feature']")).getText();
					
		System.out.println(b);
	}

}
