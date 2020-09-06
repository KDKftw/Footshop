package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class PanskeBoty {

WebDriver driver;

@FindBy(css="#filter-manufacturer > div > div.AdvancedFeatureContainer_itemsContainer_Jd_G7 > div:nth-child(7) > a")
WebElement converseCheckbox;

@FindBy(css="#page-1 > div:nth-child(4) > div.Product_wrapper_HOAyR.Product_light_BLc7O > a > div > div > img")
WebElement boty;

public PanskeBoty(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void chooseConverse() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(1500);
	converseCheckbox.click();
}

public void chooseBoots() throws InterruptedException {
	Thread.sleep(2500);
	boty.click();
	
}


}
