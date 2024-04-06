package PartTwo.LessonFiveteen;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static PartTwo.LessonFiveteen.Properties.*;


@DisplayName(value = "Урок 15: Полезные советы при написании API тестов")
public class NoteTests {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    private String token;

    private void createNoteRequestSpecification(NoteCreationDTO noteCreationDTO) {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .setBaseUri(BASE_URI)
                .setBasePath(CREATE_NOTE)
                .setBody(noteCreationDTO)
                .setContentType("application/json")
                .build();
    }

    private void archiveNoteRequestSpecification() {

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .setBaseUri(BASE_URI)
                .setBasePath(ARCHIVE_NOTE)
                .setContentType("application/json")
                .build();
    }

    private void createNoteResponseSpecification (int status) {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

    private void postNote() {
        RestAssured.given(requestSpecification).log().all()
                .post()
                .then().log().all().spec(responseSpecification);

    }
    private void putNotes() {
        RestAssured.given(requestSpecification)
                .put()
                .then().log().all().spec(responseSpecification);
    }
    private void deleteNotes() {
        RestAssured.given(requestSpecification)
                .delete()
                .then().log().all().spec(responseSpecification);
    }

    @BeforeEach
    public void before() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "ASSEROV");
        paramsLogin.put("password", "Qwerty$4");

        JsonPath response = RestAssured.given()
                .formParams(paramsLogin)
                .get("http://172.24.120.5:8081/api/login")
                .jsonPath();
        token = response.get("access_token");
    }
    @Test
    @DisplayName(value ="Создание заметки")
    public void createNote() throws IOException {

        NoteCreationDTO[] noteCreationDTO = new NoteCreationDTO[1];
        noteCreationDTO[0] = NoteCreationDTO.builder()
                .name("Урок 15")
                .content("Создание заметки")
                .color("#fdcfe8")
                .priority(139)
                .build();


        createNoteRequestSpecification(noteCreationDTO[0]);
        createNoteResponseSpecification(201);
        postNote();

    }

    @Test
    @DisplayName(value ="Редактирование заметки")
    public void editNote(){
        NoteCreationDTO[] noteCreationDTO = new NoteCreationDTO[1];
        noteCreationDTO[0] = NoteCreationDTO.builder()
                .id(192)
                .name("Урок 15")
                .content("Редактирование заметки")
                .color("#fdcfe8")
                .priority(79)
                .build();

        createNoteRequestSpecification(noteCreationDTO[0]);
        createNoteResponseSpecification(204);
        putNotes();
    }

    @Test
    @DisplayName(value ="Архивирования заметки")
    public void archiveNote(){
       archiveNoteRequestSpecification();
        createNoteResponseSpecification(204);
        deleteNotes();
        }
}
