package PartTwo.DTO;

import java.util.ArrayList;
import java.util.List;
import io.restassured.RestAssured;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;


@Data
public class User {
    private String login;
    private String password;
    private String email;
    private List<Role> roles;
    private List<Note> notes;
    public void setDefaultRoles(){
        Role defaultRole = new Role();
        defaultRole.setId("2");
        defaultRole.setName("ROLE_USER");

        List<Role> defaultListRole = new ArrayList<>();
        defaultListRole.add(defaultRole);
        this.roles = defaultListRole;

    }
    public void setDefaultNotes() {
        Note defaultNote = new Note();
        defaultNote.setName("Часть 2 ур 11");
        defaultNote.setContent("DTO");
        defaultNote.setColor("#fdcfe8");
        defaultNote.setPriority(35);

        List<Note> defaultListNote = new ArrayList<>();
        defaultListNote.add(defaultNote);
        this.notes = defaultListNote;
    }
    @Test(priority = 1)
    @DisplayName(value = "Создание пользователя")
    public void setNewUser() {
        User newUser = new User();
        newUser.setLogin("L11_NewUser7");
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






    
