package PartTwo.DTO;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

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
    }






    
