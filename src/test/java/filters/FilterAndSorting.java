package filters;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterAndSorting {

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
		
		
	// capturing names of products before filteration
		List <WebElement> namebeforefilter=driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']/descendant::span[@class='a-size-base-plus a-color-base a-text-normal']"));
	
	// capturing price before sorting
		List<WebElement> pricebeforesorting=driver.findElements(By.xpath("//a[@class='a-size-base a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal']/descendant::span[@class='a-price-whole']"));
		
		
		
		
	// applying FILTER by clicking on "Elegant Comfort" as Brand
	driver.findElement(By.xpath("//li[@aria-label='Elegant Comfort']//i[@class='a-icon a-icon-checkbox']")).click();
				
	// capturing names of all products after applying filteration
	List<WebElement> brand=	driver.findElements(By.xpath("//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
	
// capturing price of product before sorting after filter as a list of webelements
	List<WebElement> pricebeforesortingafterfilter=driver.findElements(By.xpath("//a[@class='a-size-base a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal']/descendant::span[@class='a-price-whole']"));
	
	// capturing price of product before sorting after filter as a list of Strings	
	List<String> p1=pricebeforesortingafterfilter.stream().map(s->s.getText()).collect(Collectors.toList());
	
	// print price before sorting
	System.out.println("price before sorting  " +p1);
	
	// SORT the price using COLLECTION CLASS
	Collections.sort(p1);
	
	// print the price after sorting( SORTING BUTTON NOT YET CLICKED) using collection class
	System.out.println("price after sorting using COLLECTION class (SORTING BUTTON NOT CLICKED YET)  "+ p1);
	
	
	// click on "sort" dropdown
	driver.findElement(By.xpath("//span[@aria-label='Sort by:']//span//span[@data-csa-c-func-deps='aui-da-a-dropdown-button']")).click();
		
	// select "price low to high" fom dropdown
	  driver.findElement(By.id("s-result-sort-select_1")).click();
	
	// capturing price of product after sorting after filter as a list of webelements
	  List<WebElement> priceaftersorting=driver.findElements(By.xpath("//a[@class='a-size-base a-link-normal s-no-hover s-underline-text s-underline-link-text s-link-style a-text-normal']/descendant::span[@class='a-price-whole']"));
 
	// capturing names of product after sorting after filter as a list of webelements
	 List <WebElement> nameafterfilter=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
	int n1=nameafterfilter.size();
	//Assert.assertEquals(priceaftersorting, p1);
	 
// converting list of webelements( priceaftersorting) into list of strings using JAVA STREAMS   
	 List<String> p2= priceaftersorting.stream().map(s->s.getText()).collect(Collectors.toList());
	
  // PRINT price after sorting using SORTING functionality of amazon website
	System.out.println("price after sorting using SORTING functionality of amazon website  "+p2);
	
	
	// printing the names of each product after filter
	for( WebElement a: nameafterfilter)
	{
		System.out.println(System.lineSeparator()+ "AFTER FILTER"+a.getText());
	}

	// Using for loop to validate filter functionality
	for(int i=0;i<nameafterfilter.size();i++)
	{
		String afterfilter=nameafterfilter.get(i).getText();
		if(afterfilter.contains("Elegant Comfort")) {
			System.out.println("filteration test is passed");
		}
		else {
			System.out.println("filteration test is failed");
		}
	}
	
	System.out.println("no. of products on page1 is "+n1);
	
	// click on next page
		driver.findElement(By.xpath("//a[@aria-label='Go to page 2']")).click();
		Thread.sleep(7000);
	 List <WebElement> nameafterfilterpage2=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/descendant::span[@class='a-size-medium a-color-base a-text-normal']"));
		int n2=nameafterfilterpage2.size();
		
		System.out.println("no. of products on page2 is "+n2);
	}
	
	

}
