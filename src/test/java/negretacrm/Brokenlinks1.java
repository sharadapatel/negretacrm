package negretacrm;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinks1 {
	@Test
	public void launch() throws Throwable{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");
	driver.findElement(By.name("q")).sendKeys("java",Keys.ENTER);
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	List<WebElement> el =driver.findElements(By.xpath("//a[contains(@href,'https')]"));
	for(WebElement ele:el)
	{
		String link = ele.getAttribute("href");
		System.out.println(link.length());
		System.out.println(link);
		URL u = new URL(link);
		HttpURLConnection conn = (HttpURLConnection)u.openConnection();
		System.out.println(conn.getURL());
		if(conn.getResponseCode()==200)
		{
			System.out.println(conn.getResponseCode());
			System.out.println(conn.getResponseMessage());
			System.out.println("link is not broken");
		}
		else
		{
			System.out.println(conn.getResponseCode());
			System.out.println(conn.getResponseMessage());
			System.out.println("link is broken");
		}
		System.out.println("==================================================================");
	}
	driver.close();
	
}

}
