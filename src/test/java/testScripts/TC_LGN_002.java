package testScripts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_LGN_002 extends BaseTest {


    @Test
    public void TC_LGN_002(){
        LoginPage lp = new LoginPage(driver);
        lp.verifyLogin("TC_LGN_002");
        lp.verifyErrorMsg();

    }
}
