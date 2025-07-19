package Vtiger.Pages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;



public class PageObjectManager  {

private LoginPage lp;
private LeadPage ldp;
private WebDriver driver;
private HelpDeskPage hdp;
private ExtentTest logger;
private MyAccountPage map;
private ProductPage pp;
private ActivityPage ap;



public PageObjectManager(WebDriver driver,ExtentTest logger)
{
  this.driver=driver;
  this.logger=logger;
}

public LoginPage getLoginPage()
{
    if(lp==null)
    {
        lp= new LoginPage(driver,logger);
        return lp;
    }
    else {
        return lp;
    }
}

    public LeadPage getLeadPage()
    {
        if(ldp==null)
        {
            ldp= new LeadPage(driver,logger);
            return ldp;
        }
        else {
            return ldp;
        }
    }

    public HelpDeskPage getHelpDeskPage()
    {
        if(hdp==null)
        {
            hdp= new HelpDeskPage(driver,logger);
            return hdp;
        }
        else {
            return hdp;
        }
    }

    public MyAccountPage getMyAccountPage()
    {
        if(map==null)
        {
           map=new MyAccountPage(driver,logger);
           return map;
        }
        else {
            return map;
        }
    }

    public ProductPage getProductPage()
    {
        if(pp==null)
        {
            pp=new ProductPage(driver,logger);
            return pp;
        }
        else {
            return pp;
        }
    }

    public ActivityPage getActivityPage()
    {
        if(ap==null)
        {
            ap=new ActivityPage(driver,logger);
            return ap;
        }
        else {
            return ap;
        }
    }












}
