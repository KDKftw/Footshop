package page_objects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Log;

public class ExactBoty {			//DEFINING PAGEOBJECTS ON THE SPECIFIC SHOES PAGE

	@FindBy(className = "ProductProperties_hasLogo_2b-0v")
	WebElement nazevBoty;

	@FindBy(className = "Dropdown_activeItem_LAVaT")
	WebElement dropdown;

	@FindBy(xpath = "//*[@id=\"template\"]/div[5]/div/div[1]/div[2]/div[4]/div[1]/div[2]/div[2]/div[2]/div/span[2]")
	WebElement velikostBot;

	@FindBy(css = ".ProductProperties_addToCart_32JsZ")
	WebElement pridatdoKosiku;

	@FindBy(className = "ProductItem_name_2ZYz5")
	WebElement nazevBotyKosik;

	@FindBy(xpath = "//*[@id=\"ultranav\"]/div[3]/div[2]/div[1]/div/button[3]") //
	WebElement odstranZkosiku;

	@FindBy(css = "#ultranav > div.Cart_wrapper_3W-Wa.slideRight-enter-done > div.AsyncCart_products_Q5KWz > p")
	WebElement infoKosik;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div[3]/div[2]/div/div/button[1]")
	WebElement minusKosik;

	@FindBy(xpath = "/html/body/div[4]/div[2]/div[3]/div[2]/div/div/button[1]/svg/path")
	WebElement quantity;

	@FindBy(xpath = "className=ProductControls_control_1tVOu ProductControls_delete_1iSDL") //
	WebElement odstranZkosikuFF;

	WebDriver driver;

	public ExactBoty(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String jmenoBoty() {
		String nameBoty = nazevBoty.getText();
		nameBoty = nameBoty.replaceAll("\n", " ").toUpperCase();
		Log.info("The name of shoes is stored");
		return (nameBoty);
	}

	public void velikostBoty() {
		dropdown.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		velikostBot.click();
		Log.info("Number of shoe was chosen");
	}

	public void pridatDoKosiku() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		Thread.sleep(2500);
		pridatdoKosiku.click();
		Log.info("Shoe was added to basket");
	}

	public String jmenoBotyKosik() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		String nameBotyKosik = nazevBotyKosik.getText();
		Thread.sleep(1000);
		nameBotyKosik = nameBotyKosik.toUpperCase();
		Log.info("The name of shoes in basket is stored");
		return (nameBotyKosik);

	}

	public void odstranZkosiku() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		odstranZkosiku.click();
		Log.info("Item was deleted from basket");

	}

	public String infoKosik() {
		String info = infoKosik.getText();
		Log.info("The state of basket is stored");
		return (info);

	}

	public void minusKosik() throws InterruptedException {
		Thread.sleep(2000);
		minusKosik.click();
		Log.info("Item was deleted from basket");

	}

	public void odstranzKosikuFF() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		odstranZkosikuFF.click();

	}

}
