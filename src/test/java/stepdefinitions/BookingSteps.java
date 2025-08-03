package stepdefinitions;

import config.RequestResponseSpecBuilder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utility.BookingPayloadUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingSteps {

    private Map<String, Object> payload;
    private Response response;

    @Given("the booking payload is prepared with valid data")
    public void the_booking_payload_is_prepared_with_valid_data() {
        payload = BookingPayloadUtil.createRandomBookingPayload();
    }

    @When("the client sends a POST request to create a booking")
    public void the_client_sends_a_post_request_to_create_a_booking() {
        response = given()
                .spec(RequestResponseSpecBuilder.getRequestSpec())
                .body(payload)
                .when()
                .post();
    }

    @Then("the API should return status code {int}")
    public void the_api_should_return_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain the booking details")
    public void the_response_should_contain_the_booking_details() {
        response.then()
                .spec(RequestResponseSpecBuilder.getResponseSpec())
                .body("booking.firstname", equalTo(payload.get("firstname")))
                .body("booking.lastname", equalTo(payload.get("lastname")));
    }
}
