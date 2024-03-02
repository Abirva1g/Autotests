package PartTwo;

import io.restassured.RestAssured;
import org.junit.Test;
public class DzPTwoLOne {
    @Test
    public void restAssuredTest() {
        RestAssured.when()
                .get("http://172.24.120.5:8081/api/users/ASSEROV/notes")
                .then()
                .statusCode(403);

    }
}
