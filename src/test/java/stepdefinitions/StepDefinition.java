package stepdefinitions;
import io.cucumber.java.en.*;

public class StepDefinition {

    @Given("api endpoint is set with {string}")
    public void api_endpoint_is_set_with_key(String arg) {
        System.out.println("inside given"+arg);

    }

    @When("HTTP request is triggered with {string}")
    public void request_is_triggered(String arg) {
        System.out.println("inside when"+ arg);

    }

    @Then("api returns a response {string}")
    public void return_response_code(String arg) {
        System.out.println("inside then"+arg);

    }
}
