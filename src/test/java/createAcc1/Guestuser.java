package createAcc1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class Guestuser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gurpr\\eclipse-workspace\\newguru\\AmazonHuge\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/");
		
		//Guest user can navigate to any product
driver.findElement(By.linkText("Best Sellers")).click();
driver.findElement(By.xpath("//*[@id=\"B0C59BYVTQ\"]/a[2]")).click();

// Guest user can click on 'buy now' button
driver.findElement(By.id("buy-now-button")).click();

// Guest user is not allowed to buy , he is navigated to 'Sign in' page
String title=driver.getTitle();
System.out.println(title);
Assert.assertEquals("Amazon Sign In" , title);

	}

}
