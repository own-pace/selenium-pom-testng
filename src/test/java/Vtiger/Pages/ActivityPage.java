package Vtiger.Pages;

import Vtiger.Utility.PageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityPage extends PageActions {



    public ActivityPage(WebDriver driver, ExtentTest logger)
    {
        super(driver, logger);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//a[@id='showSubMenu']")
    private WebElement subMenu ;

    @FindBy(xpath="//table[@class='formOuterBorder']/descendant::input[@name='subject']")
    private WebElement subject;

    @FindBy(xpath="//table[@class='formOuterBorder']/descendant::img[@id='jscal_trigger_date_start']")
    private WebElement startDate;

    @FindBy(xpath="//table[@class='formOuterBorder']/descendant::img[@id='jscal_trigger_due_date']")
    private WebElement dueDate;

    @FindBy(xpath="(//input[@name='button'])[2]")
    private WebElement saveButton;

    @FindBy(xpath="(//div[@class='calendar']/descendant::td[@class=contains(text(),'23')])[3]")
    private WebElement startDateCalendar;

    @FindBy(xpath="(//div[@class='calendar']/descendant::td[@class=contains(text(),'30')])[4]")
    private WebElement dueDateCalendar;


    public void newTask()
    {
        getOptions(subMenu,"clicked on new task",0);


    }

    public void taskInformation(String input)
    {
        sendText(subject,input,"subject is entered");
        clickElement(startDate,"clicked on the calendar icon");
        clickElement(startDateCalendar,"start date is selected");
        clickElement(dueDate,"clicked on due date calendar icon");
        clickElement(dueDateCalendar,"due date is selected");
        clickElement(saveButton,"clicked in save button");
    }



}
