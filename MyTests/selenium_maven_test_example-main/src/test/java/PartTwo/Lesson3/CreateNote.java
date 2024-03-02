package PartTwo.Lesson3;
public class CreateNote {
    public static void main(String[] args) {
    Note NoteOne = new Note.Builder()
            .withTitle("Только заголовок")
            .build();
    Note NoteTwo = new Note.Builder()
            .withTitle("Урок 3")
            .withContent("Паттерн Builder")
            .build();
    Note NoteThree = new Note.Builder()
            .withTitle("Урок 3")
            .withContent("Домашнее задание")
            .build();

        NoteOne.noteInfo();
        NoteTwo.noteInfo();
        NoteThree.noteInfo();

    }
}
