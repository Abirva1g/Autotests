import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;


public class LessonTen {
    private int countNote(){
        List<WebElement> notes = driver.findElements(By.xpath("//div[contains(@id,'note-container')]"));
        return notes.size();
    }
    WebDriver driver;
    @BeforeEach
    public void openStendInitDriver() {
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
    }

    @Test

    @DisplayName(value = "Создание заметки")
    public void createNoteTest() {
        for (int i=0; i<3; i++) {
            //Объявляем WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //Клик по кнопке Создание заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Card_containerNew')]"))).click();
            //Заполнение Заголовка заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'note-modal-title')]"))).sendKeys("Заметка номер " + i);
            //Заполнение Содержания заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'note-modal-content')]"))).sendKeys("Содержание к заметке номер 1");
            //Нажатие на палитру
            wait.until(ExpectedConditions.elementToBeClickable(By.id("palette-btn-new_empty"))).click();
            //Выбор цвета заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'#fdcfe8')]"))).click();
            //Нажатие кнопки Ок
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-save-btn-new_empty"))).click();
        }
           }
           @Test

           @DisplayName(value = "Тест удаление заметок")

           public void waitTrash2() {
        int i = countNote();
        while (i!=0) {
            //Удаление заметки
            driver.findElement(By.xpath("//img[contains(@id, 'note-delete-btn')]")).click();
            driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
            i = countNote();
        }
        }
}
