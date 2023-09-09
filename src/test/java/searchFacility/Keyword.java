package searchFacility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keyword {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		// Type keyword "bed" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bed");
		Thread.sleep(6000);
List<WebElement> productnames=driver.findElements(By.xpath("//div[@class='left-pane-results-container']//div/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
	System.out.println(productnames.size());
	String names;
	
	 // for loop to fetch name of each suggested product
	for(int i=0;i<productnames.size();i++)
	{
	names=productnames.get(i).getText();
	System.out.println(names);
	}
	
	// for loop to click on a particular product from the list of suggested products
	for(int i=0;i<productnames.size();i++)
	{
	names=productnames.get(i).getText();
	if(names.contains("bed frame"))
	{
		productnames.get(i).click();
		break;
	}
	}
}}
