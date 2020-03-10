package negretacrm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sharada
 *
 */
public class WebDriverutils {
	/**
	 * get the random number with in the range 10000
	 * 
	 * @return
	 */
	public int getRanDomNum() {
		Random ram = new Random();
		return ram.nextInt(10000);
	}

	/**
	 * wait for element status based on visibility
	 * 
	 * @param element
	 * @param driver
	 */
	public void waitForElementToClick(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * wait for page title based on availability
	 * 
	 * @param title
	 * @param driver
	 */
	public void waitForElementToVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * wait for element to load
	 * 
	 * @param driver
	 */
	public void waitForElementToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndclickElement(WebDriver driver, WebElement element) throws InterruptedException {
		int count = 0;
		while (count <= 20) {
			try {
				element.click();
				break;
			} catch (Throwable t) {
				Thread.sleep(1000);
				count++;
			}
		}
	}

	/**
	 * used to select the content of the DropDown based on text
	 * 
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * used to select the content of the DropDown based on index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * used to take mouse cursor on the element
	 * 
	 * @param element
	 * @param driver
	 */
	public void moveToElement(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	

	public String propertydata(String key) throws IOException {
		FileInputStream fs = new FileInputStream(".//Data//commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fs);
		String data = pobj.getProperty(key);
		return data;
	}

	/**
	 * used to double click the element
	 * 
	 * @param target
	 * @param driver
	 */
	public void contextClick(WebElement target, WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick(target).perform();
	}

	/**
	 * used to doubleClick the element
	 * 
	 * @param target
	 * @param driver
	 */
	public void doubleClick(WebElement target, WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick(target).perform();
	}

	/**
	 * used to do composite click on the element
	 * 
	 * @param target
	 * @param driver
	 */
	public void compositeClick(WebElement target, WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.CONTROL).click(target).perform();
	}

	/**
	 * used to drag and drop the element
	 * 
	 * @param source
	 * @param target
	 * @param driver
	 */
	public void dragDrop(WebElement source, WebElement target, WebDriver driver) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	/**
	 * used to switch to any window based on page title
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public void switchToNewTab(WebDriver driver, String pageTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			String actPageTitle = driver.getTitle();
			if (actPageTitle.contains(pageTitle)) {
				break;
			}
		}
	}

	/**
	 * used to click OK on alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to click cancel on alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

}
