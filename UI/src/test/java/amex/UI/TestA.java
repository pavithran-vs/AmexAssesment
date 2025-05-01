package amex.UI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.CaAmexPO;
import pageObjects.CaGoldPO;
import pageObjects.GoldAmexPO;
import pageObjects.HomePagePO;
import utility.CommonMethods;
import utility.ConfigReader;

//Test class with 2 test cases
@Listeners(listeners.TestListener.class)
public class TestA extends BaseTest {
	
	//Creating object for page classes
	HomePagePO homePO;
	CaAmexPO caAmexPO; 
	GoldAmexPO goldAmexPO; 
	CaGoldPO caGoldPO;
    CommonMethods common; 
    
    @BeforeMethod
    public void setUpTestObjects() {
    	homePO = new HomePagePO(driver);
    	caAmexPO = new CaAmexPO(driver);;
    	goldAmexPO = new GoldAmexPO(driver);
    	caGoldPO = new CaGoldPO(driver);
    	common = new CommonMethods(driver); 
    }

	//Positive scenario- Checking the page title for each page, navigating to the last page and entering valid details
	@Test
    public void testPositive() {

        common.declineCookies();
        common.verifyPageTitle(ConfigReader.getProperty("homePageTitle"));
        common.clickHidden(homePO.CartesAmericanExpress_btn); 
        common.verifyPageTitle(ConfigReader.getProperty("CartesAmexTitle"));
        common.declineCookies();
        common.click(caAmexPO.enSaviorPlus_Gold_btn);
        common.verifyPageTitle(ConfigReader.getProperty("GoldAmexTitle"));
        common.declineCookies();
        common.clickHidden(goldAmexPO.DemandezVotreCarte_btn);
        common.verifyPageTitle(ConfigReader.getProperty("CarteGoldAmexTitle"));
        common.click(caGoldPO.civilite_M);
        common.click(caGoldPO.civilite_Mme);
        common.enterText(caGoldPO.pre_nom,ConfigReader.getProperty("fName_P"));
        common.enterText(caGoldPO.nom,ConfigReader.getProperty("lName_P"));
        common.enterText(caGoldPO.dateOB,ConfigReader.getProperty("dob_P"));
        common.enterText(caGoldPO.email,ConfigReader.getProperty("email_P"));
        common.enterText(caGoldPO.phone,ConfigReader.getProperty("phone_P"));
        common.clickHidden(caGoldPO.Sauvegarder_et_Continuer_btn);
        common.verifyMessage(caGoldPO.Vos_informations_personnelles_msg, ConfigReader.getProperty("cnfrm_msg"));        
}
	
	//Negative scenario- Checking the page title for each page, navigating to the last page and entering invalid details
	@Test
    public void testNegative() {

        common.declineCookies();
        common.verifyPageTitle(ConfigReader.getProperty("homePageTitle"));
        common.clickHidden(homePO.CartesAmericanExpress_btn); 
        common.verifyPageTitle(ConfigReader.getProperty("CartesAmexTitle"));
        common.declineCookies();
        common.click(caAmexPO.enSaviorPlus_Gold_btn);
        common.verifyPageTitle(ConfigReader.getProperty("GoldAmexTitle"));
        common.declineCookies();
        common.clickHidden(goldAmexPO.DemandezVotreCarte_btn);
        common.verifyPageTitle(ConfigReader.getProperty("CarteGoldAmexTitle"));
        common.declineCookies();
        common.enterText(caGoldPO.pre_nom,ConfigReader.getProperty("fName_N"));
        common.enterText(caGoldPO.nom,ConfigReader.getProperty("lName_N"));
        common.enterText(caGoldPO.dateOB,ConfigReader.getProperty("dob_N"));
        common.enterText(caGoldPO.email,ConfigReader.getProperty("email_N"));
        common.enterText(caGoldPO.phone,ConfigReader.getProperty("phone_N"));
        common.clickHidden(caGoldPO.Sauvegarder_et_Continuer_btn);
        common.verifyMessage(caGoldPO.civilite_emsg, ConfigReader.getProperty("civilite_emsg")); 
        common.verifyMessage(caGoldPO.fName_emsg, ConfigReader.getProperty("fName_emsg"));
        common.verifyMessage(caGoldPO.lName_emsg, ConfigReader.getProperty("lName_emsg"));        
        common.verifyMessage(caGoldPO.dob_emsg, ConfigReader.getProperty("dob_emsg"));        
        common.verifyMessage(caGoldPO.email_emsg, ConfigReader.getProperty("email_emsg"));        
        common.verifyMessage(caGoldPO.phone_emsg, ConfigReader.getProperty("phone_emsg"));        
        common.verifyMessage(caGoldPO.cnfrm_emsg, ConfigReader.getProperty("cnfrm_emsg"));        
}
}

