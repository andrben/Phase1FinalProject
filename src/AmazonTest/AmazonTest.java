package AmazonTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement searchBoxClick = driver.findElement(By.id("nav-search-submit-button"));
		searchBox.sendKeys("Samsung Mobile");
		searchBoxClick.click();
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-whole']"));
		List<WebElement> symbols = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		for(int i=0; i<mobiles.size();i++) {
			System.out.println(mobiles.get(i).getText() + "\t" + symbols.get(i).getText() + price.get(i).getText());
		}
		
		TakesScreenshot tsObj = (TakesScreenshot) driver;
		File fileObj = tsObj.getScreenshotAs(OutputType.FILE);
		File screenshotObj = new File("image.png");
		
		FileUtils.copyFile(fileObj,screenshotObj);
		
		driver.quit();
	}

}
