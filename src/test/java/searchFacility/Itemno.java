package searchFacility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Itemno {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		
		// Type item no. of any product in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("B088M6XLPG");
		Thread.sleep(4000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		// storing all the suggested product's name in a list
	List<WebElement> products=driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));

	 // for loop to fetch name of each suggested product
	for(int i=0;i<products.size();i++)
{
	String names=products.get(i).getText();
	// using "line separator for keeping 1 line space between text for clear view in console
	System.out.println(names+System.lineSeparator());
}
	}

}
