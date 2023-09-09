package addtocart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Productdetails {

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
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	// searching for "women formal coat" in search box
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("women formal coat");
		
	// click on search button
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	// click on one of the product
	driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Womens Waistcoat Vest Vintage Steampunk Dress Jacq')])[1]")).click();
	
	Thread.sleep(17000);
	
	// select color of product(coat)
	driver.findElement(By.xpath("(//span[@class='a-list-item']/descendant::input[@name='1'])[1]")).click();
	
	// select size of product (coat)
	//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(6));
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='a-section a-spacing-none swatch-title-text-container']/descendant::span[@class='a-size-base swatch-title-text-display swatch-title-text'])[2]"))).click();
	WebElement size=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none swatch-title-text-container']/descendant::span[@class='a-size-base swatch-title-text-display swatch-title-text'])[2]"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", size);
	// capture the name of selected product
	 String namebeforecart=driver.findElement(By.id("productTitle")).getText();
	 System.out.println(namebeforecart);
	 
	// capture the price of selected product
	 String pricebeforecart= driver.findElement(By.xpath("(//span[@class='a-offscreen'][normalize-space()='$41.99'])[1]")).getText();
	 System.out.println(pricebeforecart);
	 
	// capture the image of selected product
	 driver.findElement(By.xpath("//div[@class='imgTagWrapper']/descendant::img[@data-old-hires='https://m.media-amazon.com/images/I/51NzRyGebSL._AC_UL1500_.jpg']"));
	
	// click on "add to cart" button
	 driver.findElement(By.id("add-to-cart-button")).click();
	 
	// Click on add to cart icon on top right corner
	 driver.findElement(By.id("nav-cart-count")).click();
	 
	 // sign in button
	 //driver.findElement(By.cssSelector("#a-autoid-1-announce")).click();
	 
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
