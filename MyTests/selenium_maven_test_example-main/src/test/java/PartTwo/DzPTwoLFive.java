package PartTwo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.util.HashMap;
import java.util.Map;

public class DzPTwoLFive {


    @Test
    public void restAssuredJsonKeyTest() {

        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username","ASSEROV");
        paramsLogin.put("password","Qwerty$4");
        paramsLogin.put("count","20");

        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();

        String refresh_token = response.get("refresh_token");

        Assertions.assertNotNull(refresh_token, "Значение не найдено");

        System.out.println("Полученный токен: " + refresh_token);
    }

    @Test
    public void restAssuredJsonKeyNullTest() {

        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username","ASSEROV");
        paramsLogin.put("password","Qwerty$4");
        paramsLogin.put("count","20");

        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();

        String refresh_token2 = response.get("refresh_token2");

        Assertions.assertNotNull(refresh_token2, "Значение не найдено");

        System.out.println("Полученный токен: " + refresh_token2);
    }
}
