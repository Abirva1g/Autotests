package PartTwo.Lesson3;

public class Note {
    private String title;
    private String content;

    public static class Builder {
private Note newNote;
public Builder() {newNote = new Note(); }

        public Builder withTitle(String title){
    newNote.title = title;
    return this;
        }
        public Builder withContent(String content){
            newNote.content = content;
            return this;
        }
        public Note build(){
    return newNote;
        }
    }
    public void noteInfo() {
        System.out.printf("Заголовок:%s\tСодержание:%s\n", title, content);

    }
}
