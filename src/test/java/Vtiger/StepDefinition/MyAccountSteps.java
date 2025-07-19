package Vtiger.StepDefinition;

import Vtiger.Pages.PageObjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyAccountSteps extends BaseDefinition {

    @Given("user is on the My Account section on the home page")
    public void user_is_on_the_my_account_section_on_the_home_page()
    {
     /*   WebDriver driver= new ChromeDriver();
        driver.navigate().to("https://localhost:100");

      */
        pom= new PageObjectManager(driver,logger);
       // pom.getLoginPage().login("admin","admin");





    }

    @When("user clicks on the customized tab")
    public void user_clicks_on_the_customized_tab()
    {

    }

    @Then("user can change the tab position from the selected tab section")
    public void user_can_change_the_tab_position_from_the_selected_tab_section()
    {
        pom.getMyAccountPage().dragNdrop();

    }

    @Then("user can verify the changed position of the tabs")
    public void user_can_verify_the_changed_position_of_the_tabs()
    {
        Assert.assertEquals("","");


    }









}
