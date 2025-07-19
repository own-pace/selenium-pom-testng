package Vtiger.Pages;

import Vtiger.Utility.PageActions;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ProductPage extends PageActions {


    public ProductPage(WebDriver driver, ExtentTest logger)
    {
        super(driver,logger);
        this.driver= driver;
       // this.logger=logger;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//div[@id='tabcontainer']/descendant::a[text()='Products']")
    private WebElement products;

    @FindBy(xpath="(//table[@class='formOuterBorder'])[2]//descendant::input[@name='productcode']")
    private WebElement prdctCode;

    @FindBy(xpath="//a[text()='edit']")
    private WebElement editPrdctName;

    @FindBy(xpath="(//input[@name='button'])[3]")
    private WebElement change_btn;

    @FindBy(xpath="//a[contains(text(),'vtiger')][1]")
    private WebElement acntName;

    @FindBy(xpath="(//input[@class='button'])[1]")
    private WebElement savButton;

    @FindBy(xpath="//tr[@class='oddListRow']/descendant::a[text()='Vtiger Single User Pack']")
    private WebElement prdctName;

    @FindBy(xpath="//td[text()='Account Name:']/following::td[1]")
    private WebElement acntNameVerify;

    @FindBy(xpath="//input[@name='imagename']")
    private WebElement choseFile;



    public void clickPrdctPage()
    {
        clickElement(products,"user clicked on product tab");
    }

    public void prdctCode(String s)
    {
        sendText( prdctCode,s,"product code is entered");
        prdctCode.sendKeys(Keys.ENTER);
    }


    public void editPrdct()
    {
      clickElement(editPrdctName,"clicked on edit ");
      clickElement( change_btn,"clicked on change tab to change the account name");
    }

    public void changeAcntName() throws AWTException, InterruptedException {
        switchWindow(change_btn,acntName,"account name is changed");
        uploadFile(choseFile,"file is uploaded");
        clickElement(savButton,"clicked on save button to save the changes");
    }


    public byte[] validateChangeAcntName() throws InterruptedException {
        clickElement(prdctName,"clicked on product to verify the change");
        Thread.sleep(1000);
        acntNameVerify.getText();
        return null;
    }










}
