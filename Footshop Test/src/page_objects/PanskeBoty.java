package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class PanskeBoty {

WebDriver driver;

@FindBy(xpath="/html/body/div[5]/div/div/div[2]/div/div[1]/div[4]/div/div[2]/div[6]/a")
WebElement converseCheckbox;

@FindBy(css="#page-1 > div:nth-child(4) > div.Product_wrapper_HOAyR.Product_light_BLc7O > a > div > div > img")
WebElement boty;

public PanskeBoty(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void chooseConverse() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
	converseCheckbox.click();
}

public void chooseBoots() throws InterruptedException {
	Thread.sleep(2500);
	boty.click();
	
}


}
