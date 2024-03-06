package PartTwo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class DzPTwoLFour {

    @Test
    public void restAssuredFormParamTest() {
        Map<String, String> params = new HashMap<>();
        params.put("login","ASSEROV");
        params.put("name","ДЗ Урок 15");
        params.put("count","20");

        Map<String, String> formsLogin = new HashMap<>();
        formsLogin.put("username","ASSEROV");
        formsLogin.put("password","Qwerty$4");

        JsonPath response = RestAssured.given()
                .formParams(formsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();

        String token = response.get("access_token");

        RestAssured.given()
                .log().all()
                .header("Authorization","Bearer " + token)
                .queryParams(params)
                .get("http://172.24.120.5:8081/api/users/ASSEROV/notes")
                .then()
                .statusCode(200)
                .log().all();
    }
}

