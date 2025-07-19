package Vtiger.Pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpDeskPage extends HeaderPage{


    public HelpDeskPage(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

@FindBy(xpath="//select[@name='ticketpriorities']")
private WebElement priority;


    public String PriorityDropDown(String value)
    {
        clickNewTicket();
        dropDown(priority,value);
        //Assert.assertEquals(dropDown(priority,value),"Normal");


        return priority.getText();
    }












}
