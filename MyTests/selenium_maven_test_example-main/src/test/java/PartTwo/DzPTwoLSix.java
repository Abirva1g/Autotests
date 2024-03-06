package PartTwo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class DzPTwoLSix {
    @Test
    public void restAssuredHeadersCookiesTest() {

        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username","ASSEROV");
        paramsLogin.put("password","Qwerty$4");
        paramsLogin.put("count","20");

        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();

        String token = response.get("access_token");

        RestAssured.given()
                .log().all()
                .header("Authorization","Bearer " + token)
                .cookie("cookieName","cookieValue")
                .cookies("cookieName1","cookieValue1","cookieName2","cookieValue2")
                .formParam("login","ASSEROV")
                .get("http://172.24.120.5:8081/api/users/ASSEROV/notes/archive")
                .then()
                .statusCode(200)
                .log().all();
    }
}
