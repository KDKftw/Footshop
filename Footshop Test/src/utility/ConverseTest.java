package utility;

import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page_objects.ExactBoty;
import page_objects.Homepage;
import page_objects.PanskeBoty;

public class ConverseTest {
	String driverPath = "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe";
	String driverPathFF = "C:\\Users\\KDK\\Desktop\\Selenium Setup\\geckodriver.exe";
	WebDriver driver;
	Homepage objHomepage;
	PanskeBoty objPanskeBoty;
	ExactBoty objExactBoty;
	String URL = ("https://www.footshop.cz/cs/");

	@Test
	public void pridejConverseDoKosiku() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(URL);
		Log.info("TEST START - Chrome add to basket - Footshop web was opened-");
		objHomepage = new Homepage(driver);
		objHomepage.clickPanske();
		objPanskeBoty = new PanskeBoty(driver);
		objPanskeBoty.chooseConverse();
		objPanskeBoty.chooseBoots();
		objExactBoty = new ExactBoty(driver);
		String nameShoe = objExactBoty.jmenoBoty();
		objExactBoty.velikostBoty();
		objExactBoty.pridatDoKosiku();
		String nameBasket = objExactBoty.jmenoBotyKosik();
		assertEquals(nameShoe, nameBasket);
		Log.info("TEST DONE - Chrome add to basket");
		driver.quit();
	}

	@Test
	public void pridejConverseDoKosikuFF() throws InterruptedException {
		BasicConfigurator.configure();
		System.setProperty("webdriver.gecko.driver", driverPathFF);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(URL);
		Log.info("TEST START - Firefox add to basket -Footshop web was opened");
		objHomepage = new Homepage(driver);
		objHomepage.clickPanske();
		objPanskeBoty = new PanskeBoty(driver);
		objPanskeBoty.chooseConverse();
		objPanskeBoty.chooseBoots();
		objExactBoty = new ExactBoty(driver);
		String nameShoe = objExactBoty.jmenoBoty();
		objExactBoty.velikostBoty();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		objExactBoty.pridatDoKosiku();
		String nameBasket = objExactBoty.jmenoBotyKosik();
		System.out.println(nameShoe + " =nameShoe");
		System.out.println(nameBasket + " =nameBasket");
		assertEquals(nameShoe, nameBasket);
		Log.info("TEST DONE - Firefox add to basket");
		driver.quit();
	}

	@Test
	public void odeberzKosiku() throws InterruptedException {

		String infoPremade = ("Váš košík je prázdný");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(URL);
		Log.info("TEST START - remove from basket Chrome - Footshop web was opened");
		objHomepage = new Homepage(driver);
		objHomepage.clickPanske();
		objPanskeBoty = new PanskeBoty(driver);
		objPanskeBoty.chooseConverse();
		objPanskeBoty.chooseBoots();
		objExactBoty = new ExactBoty(driver);
		objExactBoty.velikostBoty();
		objExactBoty.pridatDoKosiku();
		objExactBoty.odstranZkosiku();
		String info = objExactBoty.infoKosik();
		assertEquals(info, infoPremade);
		Log.info("TEST DONE - Chrome remove from basket");
		driver.quit();
	}

	@Test
	public void odeberzKosikuFF() throws InterruptedException {
		String infoPremade = ("Váš košík je prázdný");
		System.setProperty("webdriver.gecko.driver", driverPathFF);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(URL);
		Log.info("TEST START - remove from basket Firefox - Footshop web was opened");
		objHomepage = new Homepage(driver);
		objHomepage.clickPanske();
		objPanskeBoty = new PanskeBoty(driver);
		objPanskeBoty.chooseConverse();
		objPanskeBoty.chooseBoots();
		objExactBoty = new ExactBoty(driver);
		objExactBoty.velikostBoty();
		objExactBoty.pridatDoKosiku();
		objExactBoty.minusKosik();
		//objExactBoty.odstranzKosikuFF();
		String info = objExactBoty.infoKosik();
		assertEquals(info, infoPremade);
		Log.info("TEST DONE - Firefox remove from basket");
		driver.quit();

	}

}
