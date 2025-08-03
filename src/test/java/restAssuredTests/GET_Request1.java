package restAssuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GET_Request1 {

    @Test
    public void  getBookingDetails(){

        given()
                .when()
                       .get("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("firstname", equalTo("Mark"))
                .header("Content-Type", "application/json; charset=utf-8");
    }
}
