package pages;

import net.bytebuddy.description.type.TypeList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaUtils;

import java.util.HashMap;

public class LoginPage extends BaseClass{


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    // Object Repo

    @FindBy(id="username")
    public  WebElement userNameTextField;

    @FindBy(name="pwd")
    public   WebElement passwordTextField;

    @FindBy(id="loginButton")
    public WebElement loginButton;

    @FindBy(id="toPasswordRecoveryPageLink")
    public WebElement toPasswordRecoveryPageLink;

    @FindBy(id="headerContainer")
    public WebElement headerContainer;

    @FindBy(xpath="//span[text()='Username or Password is invalid. Please try again.']")
    public WebElement errorMessage;




    HashMap<String, String> lp;


    // Business Login

    public void verifyLogin(String tcId){
        lp = JavaUtils.readExcelData("Login",tcId);
        try {
            Thread.sleep(10000);
        }catch (Exception e){

        }
        assertTitle(headerContainer,"Please identify yourself");
        userNameTextField.sendKeys(lp.get("USERNAME"));
        passwordTextField.sendKeys(lp.get("PASSWORD"));
        loginButton.click();
    }



    public void verifyErrorMsg(){
        assertTitle(errorMessage,"Username or Password is invalid. Please try again.");
    }

}
