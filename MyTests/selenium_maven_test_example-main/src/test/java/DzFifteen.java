import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Duration;


public class DzFifteen {
    int userId;
    int numNote;
    int maxNoteId ;
    String userLogin = "ASSEROV";
    WebDriver driver;

    @BeforeEach
    public void createNote() {
       executeQuery();
    }
    @DisplayName(value = "Урок 15: Базы данных")
    @Test
    public void checkCreateNote() {
        //Объявление драйвера браузера
        driver = new ChromeDriver();
        // Ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Открытие стенда
        driver.get("http://172.24.120.5:8081/login");
        //Ввод логина
        driver.findElement(By.id("login-input")).sendKeys("ASSEROV");
        //Ввод пароля
        driver.findElement(By.id("password-input")).sendKeys("Qwerty$4");
        //Клик по кнопке Войти
        driver.findElement(By.id("form_auth_button")).click();
        // Текст заголовка заметки
        String titleText = driver.findElement(By.id("note-title-"+maxNoteId)).getText();
        // Проверка заголовка текста
        Assertions.assertEquals("ДЗ Урок 15", titleText, "Неверный заголовок заметки");
        // Текст содержания заметки
        String contentText = driver.findElement(By.id("note-content-"+maxNoteId)).getText();
        //Убираем строчку с заголовком заметки
        String noteContentText = contentText.substring(contentText.indexOf("\n")+1);
        //Проверка содержания заметки
        Assertions.assertEquals("Базы данных",noteContentText, "Неверное описание заметки");
    }
    @AfterEach
    public void closeDriver() {
        //Закрытие браузера
        driver.quit();
    }
    public void executeQuery() {
        try {
            String url = "jdbc:postgresql://172.24.120.5:5432/postgres";
            String login = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, login, password);
            try {
                String sqlUserId = "SELECT ID FROM nfaut.users WHERE login = ?";
                PreparedStatement statementOne= connection.prepareStatement(sqlUserId);
                statementOne.setString(1, userLogin);
                ResultSet resultId = statementOne.executeQuery();


                while (resultId.next()){
                userId = resultId.getInt(1);
                //System.out.println("ID: " + userId);
                }
                statementOne.close();

                String sqlnumNote = "SELECT MAX(priority)+1 FROM nfaut.notes where user_id = ?";
                PreparedStatement statementTwo = connection.prepareStatement(sqlnumNote );
                statementTwo.setInt(1, userId);
                ResultSet resultNum= statementTwo.executeQuery();
                while (resultNum.next()){
                numNote = resultNum.getInt(1);
                //System.out.println("ID: " + numNote);
                }
                statementTwo.close();

                Statement statement = connection.createStatement();
                ResultSet resultNoteId = statement.executeQuery( "select MAX(id)+1 FROM nfaut.notes");
                while (resultNoteId.next()){
                maxNoteId = resultNoteId.getInt(1);
                //System.out.println("ID: " + maxNoteId);
                }
                statement.close();
                String updateNote = "insert into nfaut.notes (id,user_id, name , color , content , priority ,archive_flg) values (?,?,'ДЗ Урок 15','#fdcfe8', 'Базы данных',?, false)";
                PreparedStatement statementThree = connection.prepareStatement(updateNote);
                statementThree.setInt(1, maxNoteId);
                statementThree.setInt(2, userId);
                statementThree.setInt(3, numNote);
                statementThree.executeUpdate();

                statementThree.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


