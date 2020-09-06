package utility;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.ExactBoty;
import page_objects.Homepage;
import page_objects.PanskeBoty;

public class ConverseTest {
	String driverPath = "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe";
	WebDriver driver;
	Homepage objHomepage;
	PanskeBoty objPanskeBoty;
	ExactBoty objExactBoty;
	

	@Test
	public void pridejConverseDoKosiku() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.footshop.cz/cs/");
		
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
		
	}



}

	
	

