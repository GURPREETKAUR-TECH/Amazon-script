package searchFacility;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DescriptionText {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		  
		// Type description text in search box
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("a tool to cut glass");
	    Thread.sleep(6000);
		List <WebElement>products=driver.findElements(By.xpath("//div[@class='left-pane-results-container']//div/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		
		String names;
		 // for loop to fetch name of each suggested product
		for (int i=0;i<products.size();i++)
{
	names=products.get(i).getText();
	System.out.println(names);
}
		
		// for loop to click on a particular product from the list of suggested products
		for (int i=0;i<products.size();i++)
		{
			names=products.get(i).getText();
			if(names.contains("auto glass cut out tool"))
			{
				products.get(i).click();
			}
		
	}
		

}}
