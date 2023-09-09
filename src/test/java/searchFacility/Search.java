package searchFacility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		// searching for "laptop" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
		Thread.sleep(6000);
		
		// storing all the suggested product's name in a list
		List<WebElement> products=driver.findElements(By.xpath("//div[@class='left-pane-results-container']//div/descendant::div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
     System.out.println(products.size());
     
     // for loop to fetch name of each suggested product
     String productname;
     for(int i=0;i<products.size();i++)
     {
    	 productname= products.get(i).getText();
    	System.out.println(productname);
     }
     
     // for loop to click on a particular product from the list of suggested products
     for(int i=0;i<products.size();i++)
     {
    	 productname= products.get(i).getText();
    	if(productname.contains("laptop")) 
    	{
    		products.get(i).click();
    		break;
    	}
    
     }
	}

}
