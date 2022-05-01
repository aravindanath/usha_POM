package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.JavaUtils;

import java.util.HashMap;

public class HomePage extends BaseClass{


    public HomePage(WebDriver driver) {
        super(driver);

    }

    // Object Repo

    @FindBy(xpath="(//div[@class='switcherBackground'])[1]")
    public  WebElement notReadySwitcher;

    @FindBy(xpath=" (//div[text()='Save'])[1]")
    public  WebElement saveButton;


    @FindBy(xpath="(//*[contains(text(),'Ready for Approval')])[1]")
    public  WebElement readyForApproval;





    HashMap<String, String> hp;


    // Business Login

    public void verifySaveButton(){
        notReadySwitcher.click();
        assertElementIsDisplayed(saveButton);
        saveButton.click();
        assertTitle(readyForApproval,"Ready for Approval");
    }





}
