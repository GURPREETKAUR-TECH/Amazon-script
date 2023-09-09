package pagination;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Nextpage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		// searching for "laptop" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
		
		// clicking on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		// capture the url of current page
		String page1=driver.getCurrentUrl();
		System.out.println(page1);
		
		// click on next page
		driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
		
		// capture the url of second page
		String page2=driver.getCurrentUrl();
		System.out.println(page2);
		
		// using assertion to validate
		Assert.assertEquals(page1,page2);

	}

}
