package Examp;

import io.restassured.RestAssured;
import org.junit.Test;
public class ExampLesTwo {
    @Test
    public void createUserTest() {
        RestAssured.given()
                    .get("https://randomuser.me/api/")

                .andReturn()
                .prettyPrint();


    }
}
