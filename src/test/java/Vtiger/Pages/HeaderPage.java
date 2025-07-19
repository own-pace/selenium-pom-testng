package Vtiger.Pages;

import Vtiger.StepDefinition.BaseDefinition;
import Vtiger.Utility.PageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends PageActions {


    public HeaderPage(WebDriver driver, ExtentTest logger)
    {
        super(driver,logger);
        //this.driver= driver;
        PageFactory.initElements(driver,this);
    }
   

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;

    @FindBy(xpath="//td[@class='moduleMenuBg'][2]/table/tbody/tr/td[9]/a[text()='New Ticket']")
    private WebElement new_tkt;

    @FindBy(xpath="//td[@class='moduleMenuBg']/descendant::a[text()='New Lead']")
    private WebElement newLead;


    public void clickLogOut()
    {
        clickElement(logout,"logout link is displayed on home page");
    }

    public void clickNewTicket()
    {
        clickElement(new_tkt,"new ticket link is clicked");
    }

    public void clickLeads()
    {
        clickElement(newLead,"clicked on leads");

    }










}
