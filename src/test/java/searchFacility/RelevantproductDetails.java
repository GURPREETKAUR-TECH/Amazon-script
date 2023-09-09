package searchFacility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelevantproductDetails {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		// searching for "laptop" in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptops");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String details=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small'])[1]")).getText();
System.out.println(details);
	}

}
