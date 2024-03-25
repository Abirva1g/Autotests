package PartTwo.AnotherChecking;


import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import lombok.Data;
import org.apache.groovy.json.internal.IO;
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
    }
