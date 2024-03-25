package PartTwo.DTO;

import lombok.*;
import java.util.List;
@Getter
@Setter
public class UserCreationDTO {
    private String login;
    private String password;
    private String email;
    private List<Role> roles;
    private List<Note> notes;
}
