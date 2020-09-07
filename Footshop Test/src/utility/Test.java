package utility;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.ExactBoty;
import page_objects.Homepage;
import page_objects.PanskeBoty;

public class Test {
	String driverPath = "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe";
	WebDriver driver;
	Homepage objHomepage;
	PanskeBoty objPanskeBoty;
	ExactBoty objExactBoty;
	String URL = ("https://www.footshop.cz/cs/");

	// CREATING OF THE CODE, NOT NEEDED FOR EXECUTING THE TESTS IN ConverseTest

	public void funkce() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(URL);
		Log.info("Footshop web was opened");
		objHomepage = new Homepage(driver);
		objHomepage.clickPanske();
		objPanskeBoty = new PanskeBoty(driver);
		objPanskeBoty.chooseConverse();
		objPanskeBoty.chooseBoots();
		objExactBoty = new ExactBoty(driver);
		objExactBoty.velikostBoty();
		objExactBoty.pridatDoKosiku();
		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		

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
		driver.findElement(By.cssSelector(
				"#page-1 > div:nth-child(4) > div.Product_wrapper_HOAyR.Product_light_BLc7O > a > div > div > img"))
				.click();

		WebElement boty = driver.findElement(By.className("ProductProperties_hasLogo_2b-0v"));
		String nazev = boty.getText();
		nazev = nazev.replaceAll("\n", " ");
		nazev = nazev.toUpperCase();

		System.out.println(nazev);
		driver.findElement(By.className("Dropdown_activeItem_LAVaT")).click();
		driver.findElement(By
				.xpath("//*[@id=\"template\"]/div[5]/div/div[1]/div[2]/div[4]/div[1]/div[2]/div[2]/div[2]/div/span[2]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"template\"]/div[5]/div/div[1]/div[2]/div[5]/button")).click();
		Thread.sleep(2500);

		WebElement shoesname = driver.findElement(By.xpath("//*[@id=\"ultranav\"]/div[3]/div[2]/div[1]/a/strong"));
		String botaname = shoesname.getText();
		botaname = botaname.toUpperCase();
		assertEquals(botaname, nazev);
	}

}