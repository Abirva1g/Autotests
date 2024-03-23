package PartTwo.AnotherChecking;


import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import lombok.Data;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
    public class User {
    private String login;
    private String password;
    private String email;
    private List<Role> roles;
    private List<Note> notes;

    public void setDefaultRoles() {
        Role defaultRole = new Role();
        defaultRole.setId("2");
        defaultRole.setName("ROLE_USER");

        List<Role> defaultListRole = new ArrayList<>();
        defaultListRole.add(defaultRole);
        this.roles = defaultListRole;

    }

    public void setDefaultNotes() {
        Note defaultNote = new Note();
        defaultNote.setName("Часть 2 ур 13");
        defaultNote.setContent("Проверки");
        defaultNote.setColor("#fdcfe8");
        defaultNote.setPriority(35);

        List<Note> defaultListNote = new ArrayList<>();
        defaultListNote.add(defaultNote);
        this.notes = defaultListNote;
    }

    @Test(priority = 1)
    public void setNewUser() {
        User newUser = new User();
        newUser.setLogin("LEThirteen_NewUser9");
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
        paramsLogin.put("username", "LEThirteen_NewUser9");
        paramsLogin.put("password", "Qwerty$4");
        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();
        String token = response.get("access_token");

        GetMeDTO getMeDTOExpected = new GetMeDTO();
        getMeDTOExpected.setId(80);
        getMeDTOExpected.setLogin("LEThirteen_NewUser9");
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
            paramsLogin.put("username", "LEThirteen_NewUser9");
            paramsLogin.put("password", "Qwerty$4");
            JsonPath response = RestAssured.given()
                    .formParams(paramsLogin)
                    .get("http://172.24.120.5:8081/api/login")
                    .jsonPath();
            String token = response.get("access_token");


        RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .get("http://172.24.120.5:8081/api/users/LEThirteen_NewUser9/notes")
                .then()
                .statusCode(200).assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("note_schema.json"));
    }
    }
