package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page class - web element repository
public class CaGoldPO {
	
	WebDriver driver;
	
    public CaGoldPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = "#fieldControl-input-title > div > div:nth-child(1) > label")
    public WebElement civilite_M ;
    
    @FindBy(css = "#fieldControl-input-title > div > div:nth-child(2) > label > span")
    public WebElement civilite_Mme ;
    
    @FindBy(xpath = "//*[@id=\"fieldControl-input-firstName\"]")
    public WebElement pre_nom ;
    
    @FindBy(xpath = "//*[@id=\"fieldControl-input-lastName\"]")
    public WebElement nom ;
    
    @FindBy(xpath = "//*[@id=\"fieldControl-input-dateOfBirth\"]")
    public WebElement dateOB ;
    
    @FindBy(xpath = "//*[@id=\"fieldControl-input-email\"]")
    public WebElement email ;
    
    @FindBy(xpath = "//*[@id=\"fieldControl-input-mobilePhoneNumber\"]")
    public WebElement phone ;
    
    @FindBy(css = "#cosmos-form-section > div > div > div > div:nth-child(2) > div > div > div.col-lg-9.col-xl-7.col-xl-offset-1 > div:nth-child(3) > form > div.row.pad-0.text-align-center-sm-down.margin-4-tb > div > button")
    public WebElement Sauvegarder_et_Continuer_btn ;
        
    @FindBy(xpath = "//*[text()='Vos informations personnelles']")
    public WebElement Vos_informations_personnelles_msg;
    
    @FindBy(xpath = "/html/body/div[1]/main/main/section[2]/div/div/div/div[2]/div/div/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div/div[2]/span/div")
    public WebElement civilite_emsg;
    
    @FindBy(xpath = "/html/body/div[1]/main/main/section[2]/div/div/div/div[2]/div/div/div[1]/div[3]/form/div[1]/div[1]/div[2]/div/div/div[3]/span/div")
    public WebElement fName_emsg;
    
    @FindBy(xpath = "/html/body/div[1]/main/main/section[2]/div/div/div/div[2]/div/div/div[1]/div[3]/form/div[1]/div[1]/div[3]/div/div/div[3]/span/div")
    public WebElement lName_emsg;

    @FindBy(xpath = "/html/body/div[1]/main/main/section[2]/div/div/div/div[2]/div/div/div[1]/div[3]/form/div[1]/div[1]/div[4]/div/div/div[3]/span/div")
    public WebElement dob_emsg;
    
    @FindBy(xpath = "/html/body/div[1]/main/main/section[2]/div/div/div/div[2]/div/div/div[1]/div[3]/form/div[1]/div[1]/div[5]/div/div/div[3]/span/div")
    public WebElement email_emsg;
    
    @FindBy(xpath = "/html/body/div[1]/main/main/section[2]/div/div/div/div[2]/div/div/div[1]/div[3]/form/div[1]/div[1]/div[6]/div/div/div[3]/span/div")
    public WebElement phone_emsg;
    
    @FindBy(xpath = "/html/body/div[1]/main/main/section[2]/div/div/div/div[2]/div/div/div[1]/div[3]/form/div[2]/div/span/div/span[2]")
    public WebElement cnfrm_emsg;
}
