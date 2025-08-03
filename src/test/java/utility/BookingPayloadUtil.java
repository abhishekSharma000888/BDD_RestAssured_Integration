package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BookingPayloadUtil {

    private static final String[] FIRST_NAMES = {"John", "Alice", "Robert", "Abhishek", "Kalia"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Sharma", "Ericsson"};
    private static final String[] ADDITIONAL_NEEDS = {"Breakfast", "Lunch", "Late Checkout", "None"};

    private static final Random RANDOM = new Random();

    public static Map<String, Object> createRandomBookingPayload() {
        Map<String, Object> payload = new HashMap<>();

        payload.put("firstname", getRandom(FIRST_NAMES));
        payload.put("lastname", getRandom(LAST_NAMES));
        payload.put("totalprice", RANDOM.nextInt(900) + 100); // price between 100–999
        payload.put("depositpaid", RANDOM.nextBoolean());

        // Booking dates
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");
        payload.put("bookingdates", bookingDates);

        // Optional field - 50% chance to include it
        if (RANDOM.nextBoolean()) {
            payload.put("additionalneeds", getRandom(ADDITIONAL_NEEDS));
        }

        return payload;
    }

    private static String getRandom(String[] values) {
        return values[RANDOM.nextInt(values.length)];
    }
}
