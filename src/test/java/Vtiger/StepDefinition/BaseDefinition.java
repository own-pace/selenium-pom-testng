package Vtiger.StepDefinition;

import Vtiger.Pages.PageObjectManager;

import Vtiger.Utility.AssertionActions;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseDefinition   {

  public static WebDriver driver;
  public PageObjectManager pom;
  public Properties prop;
  public static ExtentReports extent;
  public static String TcName;

  public static ExtentTest logger;

  public AssertionActions assct;



  public void readProperties() throws IOException {

      extentReport();
    prop= new Properties();
    InputStream file= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
    prop.load(file);

  }


  public void launchApp() throws IOException {
    readProperties();
    if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
    {
      driver= new ChromeDriver();

    }
    else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
    {
      driver= new FirefoxDriver();

    }
    else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
    {
      driver= new EdgeDriver();

    }

    driver.get(prop.getProperty("appUrl"));
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


  }

  public void extentReport()
  {
   Date d= new Date();
   DateFormat ft= new SimpleDateFormat("ddMMyyyyhhmmss");
   String fileName= ft.format(d);

    ExtentSparkReporter  spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\java\\Vtiger\\reports\\extentReports"+fileName+".html");

    extent= new ExtentReports();
    extent.attachReporter(spark);



    
  }
















}
