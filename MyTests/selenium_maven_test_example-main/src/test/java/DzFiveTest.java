import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;



@DisplayName(value = "Домашнее задание - Урок 5: JUnit:Утверждения")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DzFiveTest {
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
    @Order(1)
    @DisplayName(value = "Создание заметки")
    public void createNoteTest() {
        //Объявляем WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Клик по кнопке Создание заметки
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Card_containerNew')]"))).click();
        //Заполнение Заголовка заметки
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'note-modal-title')]"))).sendKeys("Заметка номер 1");
        //Заполнение Содержания заметки
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'note-modal-content')]"))).sendKeys("Содержание к заметке номер 1");
        //Нажатие на палитру
        wait.until(ExpectedConditions.elementToBeClickable(By.id("palette-btn-new_empty"))).click();
        //Выбор цвета заметки
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'#fdcfe8')]"))).click();
        //Нажатие кнопки Ок
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-save-btn-new_empty"))).click();
        //Получаем ид последнего контейнера заметок
        String lastId = driver.findElement(By.xpath("//*[contains(@*,'note-container')][last()]")).getAttribute("id");
        //Обрезаем ид заметки
        lastId=lastId.substring(15);
        //Поиск заголовка последней заметки
        String titleText = driver.findElement(By.id("note-title"+'-'+lastId)).getText();
        //Сравнение
        Assertions.assertEquals("Заметка номер 1", titleText, "Неверный заголовок заметки");
    }

    @Test
    @Order(2)
    @DisplayName(value = "Содержание заметки")
    public void checkNoteTextTest()  {
        //Находим последний ид заметки
        String lastId = driver.findElement(By.xpath("//*[contains(@*,'note-container')][last()]")).getAttribute("id");
        //Обрезаем ид заметки
        lastId="note-content-"+lastId.substring(15);
        //Поиск содержания последнего контейнера заметки
        String contentText = driver.findElement(By.id(lastId)).getText();
        //Убираем строчку с заголовком заметки
        String noteContentText = contentText.substring(contentText.indexOf("\n")+1);
        //Сравнение
        Assertions.assertEquals("Содержание к заметке номер 1",noteContentText, "Неверное описание заметки");
    }

    @Test
    @Order(3)
    @DisplayName(value = "Цвет заметки")
    public void checkNoteColorTest() {
        //Сохранение цвета заметки
        String colorNote = driver.findElement(By.xpath("//div[contains(@id,'note-container')][last()]")).getCssValue("background-color");
        //Сравнение
        Assertions.assertEquals("rgba(253, 207, 232, 1)", colorNote, "Неверный цвет заметки");
    }

    @AfterEach
    public void closeDriver() {
        //Закрытие браузера
        driver.quit();
    }
}
