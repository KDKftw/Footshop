package page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage {

WebDriver driver;

@FindBy(className="MainItem_main_2S6WB")
WebElement panske;


public void clickPanske() {
	panske.click();
	}

}
