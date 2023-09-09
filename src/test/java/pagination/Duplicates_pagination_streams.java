package pagination;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Duplicates_pagination_streams {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		
		Thread.sleep(12000);
		// searching for "laptop" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
		
		// click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		// capturing names of all products on first page in a list
	List<WebElement> productsweb=	driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
	Thread.sleep(8000);
	
	// click on next page
	driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
	Thread.sleep(7000);
	
	// capturing names of all products on second page in a list
	List<WebElement> productsweb2=	driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		
	// applying streams filter to find any duplicates on both pages
	List < String > matches = productsweb.stream().filter( s -> productsweb2.contains( s ) ).map(s->s.getText()).collect( Collectors.toList() );
	
	// printing the size and names of any duplicates
	System.out.println(matches.size());
	System.out.println(matches);
	
	
	}

}
