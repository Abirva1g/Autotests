package PartTwo.LessonFourteen;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateNoteTest {
    ArrayList<Map<String, String>> arrayList = new ArrayList<>();
    Map<String, String> request = new HashMap<>();
private String token;
    @BeforeEach
    public void before() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "ASSEROV");
        paramsLogin.put("password", "Qwerty$4");

        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();
        token = response.get("access_token");
    }
@Test
@DisplayName(value = "Создание заметки со всеми обязательными параметрами")
public void allParamsTest() {

    request.put("name", "ДЗ Часть 2 Урок 14");
    request.put("content", "Rest Assured Request and Response Specifications");
    request.put("color", "#fdcfe8");
    request.put("priority", "73");
    arrayList.add(request);
}
    @Test
    @DisplayName(value = "Создание заметки только с параметром name")
    public void nameParamTest() {

        request.put("name", "ДЗ Часть 2 Урок 14");
        arrayList.add(request);
    }
    @Test
    @DisplayName(value = "Создание заметки только с параметрами name и content")
    public void nameContentParamTest() {

        request.put("name", "ДЗ Часть 2 Урок 14");
        request.put("content", "Rest Assured Request and Response Specifications");
        arrayList.add(request);
    }
    @AfterEach
    public void after()  {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization","Bearer " + token)
                .setBaseUri("http://172.24.120.5:8081")
                .setBasePath("/api/users/ASSEROV/notes")
                .setBody(arrayList)
                .setContentType("application/json")
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();


        RestAssured.given(requestSpecification)
                .post()
                .then().log().all().spec(responseSpecification);

        arrayList.clear();

    }
}
