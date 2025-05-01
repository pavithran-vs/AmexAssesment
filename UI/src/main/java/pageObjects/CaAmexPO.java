package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page class - web element repository
public class CaAmexPO {
	
	WebDriver driver;
	
    public CaAmexPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[@href='https://www.americanexpress.com/fr/carte-de-paiement/gold-card-americanexpress/?intlink=fr-proprietary-gold']")
    public WebElement enSaviorPlus_Gold_btn ;

}
