package page_objects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Log;

public class ExactBoty {

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

	@FindBy(css = "html.wf-proximanova-n7-active.wf-proximanova-n4-active.wf-active body#template.lang_cs.promoStripeVisible div div#ultranav.Ultranav_ultranav_3-LWG div.Cart_wrapper_3W-Wa.slideRight-enter-done div.AsyncCart_products_Q5KWz div.ProductItem_product_1sWAp div.ProductControls_controls_5qP4l button.ProductControls_control_1tVOu svg path")
	WebElement minusKosik;

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

	public String jmenoBotyKosik() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		String nameBotyKosik = nazevBotyKosik.getText();
		nameBotyKosik = nameBotyKosik.toUpperCase();
		Log.info("The name of shoes in basket is stored");
		return (nameBotyKosik);

	}

	public void odstranZkosiku() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		odstranZkosiku.click();

	}

	public String infoKosik() {
		String info = infoKosik.getText();
		return (info);
	}

	public void minusKosik() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		minusKosik.click();

	}

}
