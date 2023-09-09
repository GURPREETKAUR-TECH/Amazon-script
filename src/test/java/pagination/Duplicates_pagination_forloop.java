package pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Duplicates_pagination_forloop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		// searching for "laptop" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
		
		// click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		// capturing names of all products on first page in a list
	List<WebElement> productsweb=	driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
	
	// no. of products on page1
	System.out.println("No. of products on page1 is "+ productsweb.size());
	
	// create a list of string
	List<String> productstring=new ArrayList<>();
	
	// for loop to convert items from list of webelements to list of string
	for(int i=0;i<productsweb.size();i++)
	{
		productstring.add(productsweb.get(i).getText());
		//System.out.println(productsweb.get(i).getText()+System.lineSeparator());
	}
	
	// click on next page
	Thread.sleep(6000);
	driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
	Thread.sleep(7000);
	
	// capturing names of all products on second page in a list
	List<WebElement> productsweb2=	driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
	
	// no. of products on page2
	int s=productsweb2.size();
	System.out.println("no. of products on page2 is " + s);
	
	// create a list of string
	List<String> productstring2=new ArrayList<>();
	
	// for loop to convert items from list of webelements to list of string
	for(int i=0;i<productsweb2.size();i++)
	{
		productstring2.add(productsweb2.get(i).getText());
		//System.out.println(productsweb.get(i).getText()+System.lineSeparator());
	}
	
	
//Assert.assertEquals(productstring, productstring2);
 //productstring.retainAll(productstring2);
 //System.out.println(productstring);
	
	// TO COMPARE ANY DUPLICATES PRODUCTS ON PAGE1 AND PAGE2
	for(String g : productstring){
         if(productstring2.contains(g)){
           System.out.println("List 2 contains: " + g);
         }
        
        	}
}}
