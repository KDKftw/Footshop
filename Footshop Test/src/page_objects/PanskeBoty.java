package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Log;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

public class PanskeBoty {

	WebDriver driver;

	@FindBy(css = "#filter-manufacturer > div > div.AdvancedFeatureContainer_itemsContainer_Jd_G7 > div > a")
	WebElement converseCheckbox;

	@FindBy(css = "#page-1 > div:nth-child(4) > div.Product_wrapper_HOAyR.Product_light_BLc7O > a > div > div > img")
	WebElement boty;

	@FindBy(css = "#filter-manufacturer > div > div.SearchFilter_filter_1K-fG > input[type=text]")
	WebElement searchBox;
	
	public PanskeBoty(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void chooseConverse() throws InterruptedException {
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		searchBox.sendKeys("converse");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		converseCheckbox.click();
		Log.info("Scrolled the page and chose Converse");
	}

	public void chooseBoots() throws InterruptedException {
		Thread.sleep(2500);
		boty.click();
		Log.info("Specific shoes were cliked");

	}

}
