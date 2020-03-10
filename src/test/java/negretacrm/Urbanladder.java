package negretacrm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Urbanladder {
	@Test
	public void launch() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.urbanladder.com");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Close')]"));
		List<WebElement> element = driver.findElements(By.xpath("//span[@class='topnav_itemname']"));
		for (WebElement ele : element) {
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			System.out.println(ele.getText());
			List<WebElement> element1 = driver.findElements(By.xpath("//div[@class='taxontype']"));
			for (WebElement ele1 : element1) {
				System.out.println(ele1.getText());
				List<WebElement> element2 = driver.findElements(By.xpath("(//a[@class='inverted'])"));
				for (WebElement ele2 : element2) {
					System.out.println(ele2.getText());
					
				}//span[@class='topnav_itemname']
			}
		}
		driver.close();
	}
}
//span[contains(.,"+menu]