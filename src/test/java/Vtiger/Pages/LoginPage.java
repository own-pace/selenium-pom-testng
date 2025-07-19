package Vtiger.Pages;


import Vtiger.Utility.PageActions;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends HeaderPage {

    WebDriver driver;

    public LoginPage(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
         //this.driver=driver;

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='user_name']")
    private WebElement uid;

    @FindBy(xpath = "//input[@name='user_password']")
    private WebElement upass;

    @FindBy(xpath = "//input[@name='Login']")
    WebElement login;

    @FindBy(xpath = "//a[text()='Logout']")
   private WebElement logout;

    @FindBy(xpath = "(//table[@align='center'])[3]/tbody/tr[4]/td/select[@name='login_theme']")
    private WebElement log_theme;


    public void login(String u, String p) {
        sendText(uid, u,u+" has been entered in username field");
        sendText(upass, p,p+" has been entered in password field");
        clickElement(login," login button clicked");
    }

    public boolean logout() {
        return elmDisplayed(logout," logout button existed on home page");


    }

    public void cLogout() {
        clickLogOut();


    }


    public boolean loginTheme() {
        return elmDisplayed(log_theme," login theme button exist on login page");


    }

    public String selectDefaultOption(String s)
    {
         getFirstSelectedOption(log_theme);
        return s;
    }

    public void optionsList(String value)
    {
        selectOptions(log_theme,value);

    }



}
