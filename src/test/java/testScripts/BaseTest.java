package testScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BaseClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

  protected   WebDriver driver;


    @BeforeClass
    public void setup(){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.get(BaseClass.getValue("url"));

    }


  @AfterClass
  public void tearDown() throws InterruptedException {
      Thread.sleep(7000);
    driver.quit();

  }
}
