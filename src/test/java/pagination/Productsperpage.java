package pagination;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Productsperpage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		// searching for "laptop" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
		
		// click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	// capturing the names of all products in a list of webelement
	List<WebElement> products=	driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
 
	// no. of products in a page
	int numberofproducts= products.size();
  System.out.println(numberofproducts);
  
 // using for loop to print the name of each product 
  for(WebElement pro : products){

	  System.out.println(pro.getText()+System.lineSeparator());
	    
	}
	}

}
