package page_objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExactBoty {

@FindBy(className="ProductProperties_hasLogo_2b-0v")
WebElement nazevBoty;	

@FindBy(className="Dropdown_activeItem_LAVaT")
WebElement dropdown;

@FindBy(xpath="//*[@id=\"template\"]/div[5]/div/div[1]/div[2]/div[4]/div[1]/div[2]/div[2]/div[2]/div/span[2]")
WebElement velikostBot;

@FindBy(css="#template > div:nth-child(10) > div > div.Product_slidesAndInfo_2fGGB > div.ProductProperties_wrapper_1uSY9 > div.ProductProperties_buttonsContainer_9_f3e > button")
WebElement pridatdoKosiku;
	
@FindBy(className="ProductItem_name_2ZYz5")
WebElement nazevBotyKosik;

WebDriver driver;

public ExactBoty(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public String jmenoBoty() {
	String nameBoty = nazevBoty.getText();
	nameBoty = nameBoty.replaceAll("\n", " ").toUpperCase();
	System.out.println(nameBoty);
	return (nameBoty);		
}	

public void velikostBoty() {
	dropdown.click();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	velikostBot.click();
	}


public void pridatDoKosiku() {
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	pridatdoKosiku.click();
	}

public String jmenoBotyKosik() {
	String nameBotyKosik = nazevBotyKosik.getText();
	nameBotyKosik = nameBotyKosik.toUpperCase();
	System.out.println(nameBotyKosik);
	return(nameBotyKosik);
	
}


}
