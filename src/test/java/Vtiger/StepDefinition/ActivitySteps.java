package Vtiger.StepDefinition;

import Vtiger.Pages.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivitySteps extends BaseDefinition {





    @When("user enters  all the required fields")
    public void user_enters_all_the_required_fields()
    {


        pom = new PageObjectManager(driver, logger);
        pom.getLoginPage().login("admin","admin");
        pom.getActivityPage().newTask();


    }

    @Then("validate the activity")
    public void validate_the_activity()
    {
        pom.getActivityPage().taskInformation("First task");

    }




}
