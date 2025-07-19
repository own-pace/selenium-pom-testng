package Vtiger.StepDefinition;

import Vtiger.Pages.PageObjectManager;
import Vtiger.Utility.AssertionActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HelpDeskSteps extends BaseDefinition {






    @Given("user should be on home page")
    public void user_should_be_on_home_page()
    {
        driver= new ChromeDriver();
        pom= new PageObjectManager(driver,logger);
        driver.get("http://localhost:100");
        pom.getLoginPage().login("admin","admin");

    }

    @When("user click one of the priority options")
    public void user_click_one_of_the_priority_options()
    {
       AssertionActions.assertEquals("High","Low");
    }

    @Then("validate the text of selected priority option")
    public void validate_the_text_of_selected_priority_option()
    {
      //  Assert.assertEquals(pom.getHelpDeskPage().PriorityDropDown("High"),"High");

    }






}
