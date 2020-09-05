package utility;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

//driver.findElement(By.className("SearchFilter_filter_1K-fG")).sendKeys("converse");
		//driver.findElement(By.xpath("//*[@id=\"filter-manufacturer\"]/div/div[1]/input")).sendKeys("converse");
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(By.className("FilterCollectionItem_svg_2YKhO")).click();

//driver.findElement(By.cssSelector("[title=\"Converse x Fear Of God Skid Grid\"]"))
//driver.findElement(By.className("LazyImage_image_3B6Lx")).click();
		//driver.findElement(By.xpath("//*[@id=\"page-1\"]/div[1]/div[2]/a/div/div/img")).click();



public class Converse {

	public static void main(String[] args) throws InterruptedException  {
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
		//driver.findElement(By.className("Item_label_240r9")).click();
		
		Log.info("Opened tab with men shoes");
		js.executeScript("window.scrollBy(0,500)", "");
		Log.info("Scrolled down the page");
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[6]/a")).click();
		Log.info("Converse shoes are displayed");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#page-1 > div:nth-child(4) > div.Product_wrapper_HOAyR.Product_light_BLc7O > a > div > div > img")).click();
		
	}
	

}
