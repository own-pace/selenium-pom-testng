package Vtiger.StepDefinition;

import Vtiger.Pages.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;

public class ProductSteps extends BaseDefinition {



    @Given("user is on the product home page")
    public void user_is_on_the_product_home_page()
    {
        pom=new PageObjectManager(driver,logger);
        //WebDriver driver= new ChromeDriver();
       // driver.get("http://localhost:100");
        pom.getLoginPage().login("admin","admin");
        pom.getProductPage().clickPrdctPage();

    }

    @When("user search for the product code")
    public void user_search_for_the_product_code()
    {
        pom.getProductPage().prdctCode("001");

    }

    @Then("from the product list user will edit the product details")
    public void from_the_product_list_user_will_edit_the_product_details()
    {
        pom.getProductPage().editPrdct();

    }

    @Then("change the account name")
    public void change_the_account_name() throws AWTException, InterruptedException {
        pom.getProductPage().changeAcntName();

    }

    @Then("validate the changes made")
    public void validate_the_changes_made() throws InterruptedException {
        Assert.assertEquals(pom.getProductPage().validateChangeAcntName(),"vtiger");

    }



}
