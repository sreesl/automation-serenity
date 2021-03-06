package stepdefinitions;
import io.cucumber.java.en.*;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static net.serenitybdd.rest.SerenityRest.given;
import io.restassured.response.Response;
import org.junit.Assert;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;



public class StepDefinition {

    RequestSpecification request;
    Response response;

    @Given("api endpoint is set with {string}")
    public void endpoint_set_with_api_key(String arg) {
        request = given().queryParam("api-key",arg);
    }

    @And("set with valid input parameter {string} {string}")
    public void endpoint_set_with_input_param(String type, String arg) {
        request = given().queryParam(type,arg);
    }

    @When("HTTP request is triggered with {string}")
    public void endpoint_is_triggered(String arg) {
        response= request.when().get(arg);
    }

    @Then("api returns a response {int}")
    public void return_response_code(int arg) {
        Assert.assertEquals(arg, response.getStatusCode());
    }

    @Given("an HTTP request is triggered with {string} {string}")
        public void trigger_endpoint(String endpoint, String key){
            response = given().header("Retry-After","30000")
                    .queryParam("api-key",key)
                    .get(endpoint).then().extract().response();
    }

    @Then("api returns a valid response")
    public void verifyValidResponse(){

        String content_type = response.header("Content-Type");
        String status = response.jsonPath().get("status");
        String copyright = response.jsonPath().get("copyright");

        Assert.assertTrue(content_type.contains("application/json"));
        Assert.assertEquals("OK", status);
        Assert.assertEquals("Copyright (c) 2021 The New York Times Company.  All Rights Reserved.", copyright);
    }

    @Then("api returns an error response")
    public void verifyErrorResponse(){

        int status_code = response.getStatusCode();
        String content_type = response.header("Content-Type");
        String status = response.jsonPath().get("status");

        Assert.assertTrue(content_type.contains("application/json"));
        Assert.assertEquals(400, status_code);
        Assert.assertEquals("ERROR", status);

    }

}
