package testScripts;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_HM_001 extends BaseTest {


    @Test
    public void TC_HM_001(){
        LoginPage lp = new LoginPage(driver);
        lp.verifyLogin("TC_LGN_001");
        HomePage hp = new HomePage(driver);
        hp.verifySaveButton();


    }
}
