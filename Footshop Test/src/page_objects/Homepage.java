package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Homepage {

WebDriver driver;


@FindBy(className="MainItem_main_2S6WB")
WebElement panske;

public Homepage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void clickPanske() {
	driver.manage().window().maximize();
	panske.click();
	}

}
