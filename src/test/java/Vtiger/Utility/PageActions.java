package Vtiger.Utility;


import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PageActions {

   // private static final Logger log = LoggerFactory.getLogger(PageActions.class);
    public WebDriverWait wait;
    public WebDriver driver;
    public  ExtentTest logger;


    public PageActions(WebDriver driver, ExtentTest logger)
    {
        this.driver= driver;
        this.logger= logger;
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public String getScreenShot() throws IOException {
        Date d= new Date();
        DateFormat df = new SimpleDateFormat("MMddyyyy");
        String fileName=df.format(d);
        String path= System.getProperty("user.dir")+"/src/test/java/Vtiger/reports/screenShot"+fileName+".png";

        TakesScreenshot tk= ((TakesScreenshot) driver);

        File capture= tk.getScreenshotAs(OutputType.FILE);
        File destination= new File(path);

        try
        {
            FileUtils.copyFile(capture,destination);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());

        }
        return path;


    }


    public void sendText(WebElement elm,String str,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(str);
            logger.pass(msg);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("unable to write the text due to error"+e.getMessage());
        }
    }

    public void clickElement(WebElement elm,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            logger.pass(msg);

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("unable to click element due to error"+e.getMessage());
        }
    }

    public boolean elmDisplayed(WebElement elm,String msg)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            logger.pass(msg);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("element not found due to error "+e.getMessage());
        }
        return true;
    }

    public boolean getFirstSelectedOption (WebElement elm)
    {
        try
        {

            wait.until(ExpectedConditions.visibilityOf(elm));
            Select sc= new Select(elm);

            sc.getFirstSelectedOption().getText();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public boolean selectOptions (WebElement elm,String vl)
    {
        try
        {

            wait.until(ExpectedConditions.visibilityOf(elm));
            StringBuilder str= new StringBuilder();
            int count =0;
            Select sc= new Select(elm);
           List<WebElement> elms= sc.getOptions();
           for(WebElement e:elms) {
               String s = e.getText();
               if (count == 0) {
                   str.append(s);
                   count++;
               } else {
                   str.append("," + s);

               }


           }
            Assert.assertEquals(str.toString(),vl);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public String dropDown(WebElement elm,String str)
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            Select sc= new Select(elm);
            sc.getOptions().get(2).click();




        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return  elm.getAttribute(str);



    }

    public void draganddrop(WebElement elm,WebElement elm1)
    {
        wait.until(ExpectedConditions.visibilityOf(elm));
        Actions ac= new Actions(driver);
        ac.dragAndDrop(elm,elm1).perform();


    }

    public void switchWindow(WebElement elm,WebElement elm1,String msg)
    {
        wait.until(ExpectedConditions.visibilityOf(elm));
       Set<String> wn= driver.getWindowHandles();
        Iterator<String> itr= wn.iterator();
        String parent =itr.next();
        String child = itr.next();

        driver.switchTo().window(child);
        elm1.click();
        driver.switchTo().window(parent);


    }

    public void uploadFile(WebElement elm,String msg) throws AWTException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(elm));
        Actions ac= new Actions(driver);
        JavascriptExecutor je = ((JavascriptExecutor) driver);
        je.executeScript("  window.scrollBy(0, 400);","");

        ac.click(elm).perform();
        Thread.sleep(500);
        String file= "C:\\Users\\Shubham T\\Downloads\\WhatsApp Image 2024-03-27 at 10.13.22 PM.jpeg";
        StringSelection ss= new StringSelection(file);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        Robot rb= new Robot();

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);


    }

    public void getOptions(WebElement elm,String msg,int option)
    {
        Select sc= new Select(elm);
        sc.getOptions().get(option).click();

    }









}
