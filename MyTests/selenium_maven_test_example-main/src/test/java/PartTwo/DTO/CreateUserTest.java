package PartTwo.DTO;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

public class CreateUserTest {
    @Test
    @DisplayName(value = "Создание пользователя")
    public void setNewUser() {
        User newUser = new User();
        newUser.setLogin("L11_NewUser10");
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
}
