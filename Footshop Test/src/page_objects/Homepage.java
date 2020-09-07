package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Log;

//PAGE OBJECTS OF HOMEPAGE
public class Homepage {

	WebDriver driver;

	@FindBy(css = "#ultranav > div.Menu_wrapper_2lzmC > div > div > div > div:nth-child(2) > a")
	WebElement panske;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickPanske() throws InterruptedException {
		driver.manage().window().maximize();
		panske.click();
		Log.info("Men accessories opened");
		Thread.sleep(1500);
	}

}
