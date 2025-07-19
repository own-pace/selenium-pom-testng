package Vtiger.Pages;


import Vtiger.Utility.PageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends HeaderPage {

    public LeadPage(WebDriver driver, ExtentTest logger)
    {
        super(driver,logger);
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    @FindBy(xpath = "//table[@class='formOuterBorder']/descendant::select[@name='salutationtype']")
    private WebElement salutation;

    @FindBy(xpath = "//table[@class='formOuterBorder']/descendant::input[@name='lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//table[@class='formOuterBorder']/descendant::input[@name='company']")
    private WebElement companyName;

    @FindBy(xpath = "//table[@class='formOuterBorder']/descendant::input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "(//input[@name='button'])[1]")
    private WebElement save;




    public void createLead(String last,String com)
    {
        clickLeads();
        getOptions(salutation,"clicked on salutation dropdown ",1);
        sendText(lastName,last,"last name is entered");
        sendText(companyName,com,"company name is entered");
        clickElement(save,"clicked on save button");




    }

    public void leadcreation (String last,String comp,String emai)
    {
        clickLeads();
        getOptions(salutation,"clicked on salutation dropdown",1);
        sendText(lastName,last,"last name is entered");
        sendText(companyName,comp,"company name is entered");
        sendText(email,emai,"email is entered");
        clickElement(save,"clicked on save button");


    }




}
