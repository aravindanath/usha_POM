package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseClass {
    protected WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public static void acceptAlert(WebDriver driver){
        Alert alert =  driver.switchTo().alert();
        System.out.println("Alert Title "+ alert.getText());
        alert.accept();
    }

    public static void dismissAlert(WebDriver driver){
        Alert alert =  driver.switchTo().alert();
        System.out.println("Alert Title "+ alert.getText());
        alert.dismiss();
    }

    public static void acceptAlert(WebDriver driver,String text){
        Alert alert =  driver.switchTo().alert();
        System.out.println("Alert Title "+ alert.getText());
        alert.sendKeys(text);
        alert.accept();
        String result =   driver.findElement(By.id("result")).getText();
        System.out.println(result);
    }


    public static void click(WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.click(element).build().perform();
    }

    public static void selectBYVisibleText(WebElement element, String text){
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public static void selectBYvalue(WebElement element, String text){
        Select sel = new Select(element);
        sel.selectByValue(text);
    }

    public static void selectBYindex(WebElement element, int index){
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }


    public static void scroll(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void takescreenshot(WebDriver driver){
        try {
            TakesScreenshot scrShot = (TakesScreenshot) driver;
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./screenshot.png");
            FileUtils.copyFile(srcFile, destFile);
        }catch (Exception e){
            e.printStackTrace();
        }




    }


    public static void waitForElement(long sec){
        try{
            Thread.sleep(sec);
        }catch (Exception e){

        }
    }


    public static void assertTitle(WebElement element,String exceptedText){
        String actual = element.getText().trim();
        System.out.println("Actual Title: "+ actual);
        Assert.assertEquals(actual,exceptedText);
    }

    public static String getValue(String key) {
        String path = System.getProperty("user.dir")+File.separator+"config.properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);

        }catch (Exception e){
            e.printStackTrace();
        }

        return value;

    }

    public void assertElementIsDisplayed(WebElement element){
        Assert.assertTrue(element.isDisplayed(),"Button is not displayed!");
    }
}
