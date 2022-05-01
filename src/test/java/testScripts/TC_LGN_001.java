package testScripts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_LGN_001 extends BaseTest {


    @Test
    public void TC_LGN_001(){
        LoginPage lp = new LoginPage(driver);
        lp.verifyLogin("TC_LGN_001");

    }
}
