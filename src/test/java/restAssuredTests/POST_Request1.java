package restAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class POST_Request1 {

    public static HashMap<String, Object> map = new HashMap<>();

    @BeforeClass
    public void postdata() {
        setBookingData("firstname", "Repeat");
        setBookingData("lastname", "Brown");
        setBookingData("totalprice", 111);
        setBookingData("depositpaid", true);

        // Booking Dates as nested map
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        setBookingData("bookingdates", bookingDates);

        // Optional
        setBookingData("additionalneeds", "Breakfast");

        RestAssured.baseURI = "https://restful-booker.herokuapp.com"; // or your base URI
        RestAssured.basePath = "/booking";
    }

    public void setBookingData(String key, Object value) {
        map.put(key, value);
    }


    @Test
    public void createABooking(){

        given()
                .contentType("application/json")
                .body(map)
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(200)
                .and()
                .body("booking.firstname", equalTo(map.get("firstname")))
                .body("booking.lastname", equalTo(map.get("lastname")));
    }
}
