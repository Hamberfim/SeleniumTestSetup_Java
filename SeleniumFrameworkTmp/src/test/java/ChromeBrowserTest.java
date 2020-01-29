
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowserTest {

	public static void main(String[] args) {
		//Anthony Hamlin
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// follow links to search for CIS classes on DMACC site
		driver.get("https://www.dmacc.edu/programs/Pages/academic.aspx");
		driver.findElement(By.xpath("//a[contains(text(),'Find a Class')]")).click();
		// select all camupus'
		driver.findElement(By.xpath("//select[@id='ctl00_PlaceHolderMain_ctl01_ctl00_Campus']//option[contains(text(),'All')]")).click();
		// select CIS
		driver.findElement(By.xpath("//option[contains(text(),'Computer Information Systems')]")).click();
		// submit search
		driver.findElement(By.xpath("//input[@id='ctl00_PlaceHolderMain_ctl01_ctl00_Submit']")).click();
		// get the current url
		String currentURL = driver.getCurrentUrl();
		System.out.println();
		System.out.println("-------URL Source-------");
		System.out.println(currentURL);
		// get each class title/info
		List<WebElement> links = driver.findElements(By.className("coursetitle"));
		// loop to print course title/info
		for (int i = 1; i < links.size(); i++) {
			String text = links.get(i).getText();
			System.out.println("-------Course-------");
			System.out.println(text);
			
		}
		
		// close and quit
		driver.close();
		driver.quit();
	}

}
