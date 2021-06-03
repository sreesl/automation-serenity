package stepdefinitions;
import io.cucumber.java.en.*;
import io.cucumber.junit.*;
import io.restassured.specification.RequestSpecification;
import static net.serenitybdd.rest.SerenityRest.given;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.junit.Assert.*;

public class StepDefinition {

    RequestSpecification request;
    Response response;

    @Given("api endpoint is set with {string}")
    public void api_endpoint_is_set_with_key(String arg) {
        System.out.println("inside given"+arg);
        request = given().queryParam("api-key",arg);
    }

    @When("HTTP request is triggered with {string}")
    public void request_is_triggered(String arg) {
        System.out.println("inside when"+ arg);
        response= request.when().get(arg);

    }

    @Then("api returns a response {int}")
    public void return_response_code(int arg) {
        System.out.println("inside then"+arg);
        Assert.assertEquals(arg, response.getStatusCode());
    }


}
