package page_objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExactBoty {

@FindBy(className="ProductProperties_hasLogo_2b-0v")
WebElement nazevBoty;	

@FindBy(className="Dropdown_activeItem_LAVaT")
WebElement dropdown;

@FindBy(xpath="//*[@id=\\\"template\\\"]/div[5]/div/div[1]/div[2]/div[4]/div[1]/div[2]/div[2]/div[2]/div/span[2]")
WebElement velikostBot;

@FindBy(xpath="//*[@id=\\\"template\\\"]/div[5]/div/div[1]/div[2]/div[5]/button")
WebElement pridatdoKosiku;
	
@FindBy(xpath="//*[@id=\\\"ultranav\\\"]/div[3]/div[2]/div[1]/a/strong")
WebElement nazevBotyKosik;

WebDriver driver;

public ExactBoty(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public String jmenoBoty() {
	String nameBoty = nazevBoty.getText();
	nameBoty = nameBoty.replaceAll("\n", " ").toUpperCase();
	return (nameBoty);		
}	

public void velikostBoty() {
	dropdown.click();
	velikostBot.click();
	}


public void pridatDoKosiku() {
	pridatdoKosiku.click();
	}

public String jmenoBotyKosik() {
	String nameBotyKosik = nazevBotyKosik.getText();
	nameBotyKosik = nameBotyKosik.toUpperCase();
	return(nameBotyKosik);
	
}


}
