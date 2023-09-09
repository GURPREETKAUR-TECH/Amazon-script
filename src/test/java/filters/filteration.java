package filters;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class filteration {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// searching for "bedsheet" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bedsheet");
		
		// click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		
	// capturing names of products before filteration
		List <WebElement> beforefilter=driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']/descendant::span[@class='a-size-base-plus a-color-base a-text-normal']"));
		
		// no. of products shown before filteration
		System.out.println("no. of products before filter is  " +beforefilter.size());
		
		// printing the names of each product before filteration
		for (WebElement b: beforefilter){
			System.out.println(System.lineSeparator()+ "BEFORE FILTER"+b.getText());
		}
		
		Thread.sleep(7000);
		
	// applying FILTER by clicking on "Elegant Comfort" as Brand
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		
		// capturing names of all products after applying filteration
	List<WebElement> brand=	driver.findElements(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
	
	// no. of products after applying filter
	System.out.println("no. of products after filter is  "+brand.size());
	

	// printing the names of each product after filter
for( WebElement a:  brand)
{
	System.out.println(System.lineSeparator()+ "AFTER FILTER"+a.getText());
}

// Using for loop to validate filter functionality
for(int i=0;i<brand.size();i++)
{
	String afterfilter=brand.get(i).getText();
	if(afterfilter.contains("Elegant Comfort")) {
		System.out.println("filteration test is passed");
	}
	else {
		System.out.println("filteration test is failed");
	}
}
	}

}
