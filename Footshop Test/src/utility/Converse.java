package utility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.ExactBoty;
import page_objects.Homepage;
import page_objects.PanskeBoty;
import utility.Log;

public class Converse {
	static String driverPath = "C:\\Users\\KDK\\Desktop\\Selenium Setup\\chromedriver.exe";
	static WebDriver driver;
	static Homepage objHomepage;
	static PanskeBoty objPanskeBoty;
	static ExactBoty objExactBoty;
	static String URL = ("https://www.footshop.cz/cs/");
//CREATING THE CODE, NOT NEEDED FOR EXECUTING THE TESTS IN ConverseTest

	public static void main(String[] args) throws InterruptedException {

		String infoPremade = ("Váš košík je prázdný");
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
		objExactBoty.odstranZkosiku();
		String info = objExactBoty.infoKosik();
		System.out.println(info);
		assertEquals(info, infoPremade);

	}

}
