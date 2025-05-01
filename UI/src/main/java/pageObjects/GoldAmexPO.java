package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page class - web element repository
public class GoldAmexPO {
	
	WebDriver driver;
	
    public GoldAmexPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = "#shop3Fr > div:nth-child(5) > div.sc_at_grid_container.readyToApply-modules__container___3wcVh > div > div.sc_at_grid_col.sc_at_grid_colSm7.sc_at_grid_colMd8.sc_at_grid_colLg7.sc_at_grid_colLgOffset1 > div.readyToApply-modules__callToAction___3OoZb.sc_textAlign_left > div > span > div > a")
    public WebElement DemandezVotreCarte_btn;

}
