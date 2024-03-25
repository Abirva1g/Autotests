package PartTwo.Hamcrest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;

public class CheckingTest {
    @Test(priority = 1)
    @DisplayName(value = "Создание пользователя")
    public void setNewUser() {
        User newUser = new User();
        newUser.setLogin("L12_NewUser10");
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
    @DisplayName(value = "Проверки")
    public void checkingHamcrestTest() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username","L12_NewUser10");
        paramsLogin.put("password","Qwerty$4");
        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();
        String token = response.get("access_token");

        RestAssured.given()
                .header("Authorization","Bearer " + token)
                .get("http://172.24.120.5:8081/api/users/L12_NewUser10/notes")
                .then()
                .statusCode(200)
                .body("[0].name",equalTo("Часть 2 ур 12"),
                        "[0].name", equalToIgnoringCase("часть 2 ур 12"),
                        "[0].name", equalToIgnoringWhiteSpace("Часть  2  ур    12"),
                        "[0].content",containsString("rest"),
                        "[0].content", startsWith("Ham"),
                        "[0].content", endsWith("est"),
                        "[0].priority", equalTo(35),
                        "[0].priority", greaterThan(30),
                        "[0].priority", greaterThanOrEqualTo(32),
                        "[0].priority", lessThanOrEqualTo(35),
                        "[0].priority", lessThan(40),
                        "[0].content", not(startsWith("rest")));
    }
}
