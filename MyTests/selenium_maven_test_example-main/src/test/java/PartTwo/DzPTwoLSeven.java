package PartTwo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DzPTwoLSeven {
    @Test
    public void restAssuredBodyTest() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username","ASSEROV");
        paramsLogin.put("password","Qwerty$4");

        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        Map<String,String> request = new HashMap<>();
        request.put("name","ДЗ Часть 2 Урок 7");
        request.put("content","Формирование тела запроса в формате JSON");
        request.put("color","#fdcfe8");
        request.put("priority","30");
        arrayList.add(request);

        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();
        String token = response.get("access_token");

        RestAssured.given()
                .header("Authorization","Bearer " + token)
                .body(arrayList)
                .contentType("application/json")
                .post("http://172.24.120.5:8081/api/users/ASSEROV/notes")
                .then().log().status()
                .statusCode(201);
    }
}
