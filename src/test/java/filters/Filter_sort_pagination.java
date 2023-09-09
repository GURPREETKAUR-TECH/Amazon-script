package filters;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Filter_sort_pagination {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		//Thread.sleep(13000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// searching for "bedsheet" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bedsheet");
		
		// click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		WebElement filter=driver.findElement(By.xpath("//li[@aria-label='Elegant Comfort']//i[@class='a-icon a-icon-checkbox']"));
		
		// applying FILTER by clicking on "Elegant Comfort" as Brand
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", filter);
		
		//WebElement filter=driver.findElement(By.xpath("//li[@aria-label='Elegant Comfort']//i[@class='a-icon a-icon-checkbox']"));

		// click on "sort" dropdown
		driver.findElement(By.xpath("(//span[@id='a-autoid-0-announce'])[1]")).click();
			
		// select "price low to high" from dropdown
		  driver.findElement(By.id("s-result-sort-select_1")).click();
		  
		// capturing names of all products on first page in a list
			List<WebElement> page1=	driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
			Thread.sleep(8000);
			
		// no. of products on page1	
		System.out.println( "no. of products on page1 is  "+page1.size());
		
		// click on page2
		driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
		Thread.sleep(6000);
		
		// capturing names of all products on second page in a list
		List<WebElement> page2=	driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
		
		// no. of products on page2
		System.out.println( "no. of products on page2 is  "+page2.size());
		
	  // applying streams filter to find any duplicates on both pages
		List<String> match=page1.stream().filter(s->page2.contains(s)).map(s->s.getText()).collect(Collectors.toList());
		
	if(match.size()==0) {
		System.out.println("There are no duplicate products on page1 and page2");
	}
	else{
		System.out.println("There are duplicate products on page1 and page2 ");
	}
		

		
		  
		  
	}

}
