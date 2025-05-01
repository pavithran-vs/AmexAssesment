package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page class - web element repository
public class HomePagePO {
	
	WebDriver driver;
	
    public HomePagePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//*[@id='user-consent-management-granular-banner-decline-all-button']")
    public WebElement cookieDecline_btn;
      
    @FindBy(xpath = "//a[@href='https://www.americanexpress.com/fr/carte-de-paiement/types-cartes/cartes-proprietaires/?inav=fr_menu_cards_pccards']")
	public WebElement CartesAmericanExpress_btn;   

}
