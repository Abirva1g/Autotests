package PartTwo.DTO;

import lombok.Data;

@Data
public class Note {
    private String name;
    private String content;
    private String color;
    private int priority;
}