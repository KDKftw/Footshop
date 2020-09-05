package utility;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Converse;

public class ConverseTest {
	
	
	
	
	@Test
	public void shoesname() throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,5);
		
		driver.get("https://www.footshop.cz/cs/");
		Log.info("Footshop web was opened");
		driver.manage().window().maximize();
		Log.info("Window was maximized");
		driver.findElement(By.className("MainItem_main_2S6WB")).click();
		Log.info("Opened tab with men shoes");
		js.executeScript("window.scrollBy(0,500)", "");
		Log.info("Scrolled down the page");
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[6]/a")).click();
		Log.info("Converse shoes are displayed");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#page-1 > div:nth-child(4) > div.Product_wrapper_HOAyR.Product_light_BLc7O > a > div > div > img")).click();
		WebElement boty = driver.findElement(By.className("ProductProperties_hasLogo_2b-0v"));
		String nazev = boty.getText();
		System.out.println(nazev);
		driver.findElement(By.className("Dropdown_activeItem_LAVaT")).click();
		driver.findElement(By.xpath("//*[@id=\"template\"]/div[5]/div/div[1]/div[2]/div[4]/div[1]/div[2]/div[2]/div[2]/div/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"template\"]/div[5]/div/div[1]/div[2]/div[5]/button")).click();
		Thread.sleep(2500);
		WebElement shoesname = driver.findElement(By.xpath("//*[@id=\"ultranav\"]/div[3]/div[2]/div[1]/a/strong"));
		String botaname = shoesname.getText();
		assertEquals(botaname, nazev);
	}
	



}

	
	

