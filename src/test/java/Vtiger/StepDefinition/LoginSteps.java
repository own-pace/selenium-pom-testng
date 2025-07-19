package Vtiger.StepDefinition;

import Vtiger.Pages.PageObjectManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;

public class LoginSteps extends BaseDefinition {

    @Before
    public void getScenario(Scenario sce)  {

        TcName=sce.getName();
        System.out.println("Current Test Case Name: " + TcName);
    }


    @After
    public void saveReport()
    {
       // extent.flush();
      // driver.quit();
    }




    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws IOException {
        launchApp();
        pom= new PageObjectManager(driver,logger);
        logger=extent.createTest(TcName);


    }
    @When("user enters valid {string} & {string} & click on login")
    public void user_enters_valid_click_on_login(String Uid, String Pwd)
    {
        pom.getLoginPage().login(Uid,Pwd);

    }
    @Then("user should validate the home page")
    public void user_should_validate_the_home_page()
    {

        Assert.assertTrue(pom.getLoginPage().logout());
        pom.getLoginPage().cLogout();


    }

    @Then("validate dropdown exist")
    public void validate_dropdown_exist()
    {

        Assert.assertTrue(pom.getLoginPage().loginTheme());
    }
    @Then("default selection should be {string}")
    public void default_selection_should_be(String Default_value)
    {

        Assert.assertEquals((pom.getLoginPage().selectDefaultOption(Default_value)),Default_value);
    }

    @Then("there should be four values in dropdown as {string}")
    public void there_should_be_four_values_in_dropdown_as(String options) {

        pom.getLoginPage().optionsList(options);
    }



}




