package Vtiger.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiObjectSteps {

    public String Endpoint;
    public Response resp;
    @Given("endpoint {string}")
    public void endpoint(String string) {
        Endpoint= string;

    }
    @When("user perform get operation")
    public void user_perform_get_operation() {
         resp= RestAssured.get(Endpoint);
        System.out.println(resp.asPrettyString());

    }
    @Then("status code should be {int}")
    public void status_code_should_be(Integer int1) {
        System.out.println(resp.getStatusCode());

    }
    @Then("record should be {int}")
    public void record_should_be(Integer int1) {

    }


}
