package PartTwo.LessonFiveteen;

import PartTwo.DTO.Note;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class NoteCreationDTO {
        private Integer id;
        private String name;
        private String content;
        private String color;
        private Integer priority;
        private List<Note> notes;
    }

