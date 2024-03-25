package PartTwo.AnotherChecking;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnotherCheckTest {
    @Test(priority = 1)
    public void setNewUser() {
        User newUser = new User();
        newUser.setLogin("LEThirteen_NewUser21");
        newUser.setPassword("Qwerty$4");
        newUser.setEmail("test@login.ru");
        newUser.setDefaultRoles();
        newUser.setDefaultNotes();

        //Создание DTO
        UserCreationDTO userCreationDTO = new UserCreationDTO();
        userCreationDTO.setLogin(newUser.getLogin());
        userCreationDTO.setPassword(newUser.getPassword());
        userCreationDTO.setEmail(newUser.getEmail());
        userCreationDTO.setRoles(newUser.getRoles());
        userCreationDTO.setNotes(newUser.getNotes());


        RestAssured.given().log().all()
                .body(userCreationDTO)
                .contentType("application/json")
                .post("http://172.24.120.5:8081/api/registration")
                .then().log().all()
                .statusCode(201);
    }

    @Test(priority = 2)
    @DisplayName(value = "DTO")
    public void checkingUserDTO() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "LEThirteen_NewUser21");
        paramsLogin.put("password", "Qwerty$4");
        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();
        String token = response.get("access_token");

        GetMeDTO getMeDTOExpected = new GetMeDTO();
        getMeDTOExpected.setId(84);
        getMeDTOExpected.setLogin("LEThirteen_NewUser21");
        getMeDTOExpected.setEmail("test@login.ru");

//DTO
        GetMeDTO GetMeDTOActual = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get("http://172.24.120.5:8081/api/users/me")
                .then().log().all()
                .statusCode(200).extract().body().as(GetMeDTO.class);

        Assertions.assertEquals(getMeDTOExpected, GetMeDTOActual);
    }
    //JSON
    @Test (priority = 3)
    @DisplayName(value = "JSON")
    public void checkingNoteJson() throws IOException {

        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "LEThirteen_NewUser21");
        paramsLogin.put("password", "Qwerty$4");
        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();
        String token = response.get("access_token");


        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get("http://172.24.120.5:8081/api/users/LEThirteen_NewUser21/notes")
                .then()
                .statusCode(200).assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("note_schema.json"));
    }
}
