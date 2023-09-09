package sorting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sortby_newarrivals {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		// searching for "laptop" in search box
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
			
		// click on search button
			driver.findElement(By.id("nav-search-submit-button")).click();
			
		// capturing the prices of all products as it appear before sorting
		List<WebElement> actuallist=	driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']//div/descendant::span[@class='a-price-whole']"));

		// click on "sort" dropdown
		driver.findElement(By.id("a-autoid-0-announce")).click();
		
		// select "new arrivalst" fom dropdown
	   driver.findElement(By.id("s-result-sort-select_4")).click();

	   //capturing the prices of all products as it appear after sorting
	   List<WebElement> sortedlist=driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']//div/descendant::span[@class='a-price-whole']"));
		
	   // compare actual list and sorted list
	   Assert.assertTrue(actuallist.equals(sortedlist));
		

	}

}
