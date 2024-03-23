package PartTwo.AnotherChecking;


import lombok.Data;


import java.util.List;
@Data
public class UserCreationDTO {
    private String login;
    private String password;
    private String email;
    private List<Role> roles;
    private List<Note> notes;
}
