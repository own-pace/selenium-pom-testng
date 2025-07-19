package Vtiger.Pages;

import Vtiger.Utility.PageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends PageActions {

    public MyAccountPage(WebDriver driver, ExtentTest logger)
    {
        super(driver, logger);
        this.driver= driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//a[text()='My Account']")
    private WebElement myacnt;

    @FindBy(xpath="//form[@id='form']/following::input[@name='Customise']")
    private WebElement custTab;

    @FindBy(xpath="//table[@id='columnlayout']/descendant::td[text()='Home']")
    private WebElement home;

    @FindBy(xpath = "//table[@id='columnlayout']/descendant::td[text()='Calendar']")
    private WebElement calendar;




    public void dragNdrop()
    {
        clickElement(myacnt,"user clicked on my account");
        clickElement(custTab,"user then clicked on customized tab");
        draganddrop(home,calendar);


    }

    public void assrt()
    {

    }









}
