package PartTwo;

import io.restassured.RestAssured;
import org.junit.Test;

public class DzPTwoLTwo {
    @Test
    public void restAssuredLogTest() {
        RestAssured.given()
                .log().all()
                .when()
                .get("http://172.24.120.5:8081/api/users/ASSEROV/notes")
                .andReturn()
                .prettyPrint();
    }
}
