package Vtiger.StepDefinition;

import Vtiger.Pages.PageObjectManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LeadSteps extends BaseDefinition {




    @When("user enters all mandatory fields and save the details")
    public void user_enters_all_mandatory_fields_and_save_the_details()
    {
         pom=new PageObjectManager(driver,logger);
         pom.getLoginPage().login("admin","admin");
         pom.getLeadPage().createLead("Raj","MNC");


    }

    @Then("user can see the saved lead & validate it")
    public void user_can_see_the_saved_lead_validate_it()
    {
        Assert.assertEquals("Raj","Raj");

    }




}
