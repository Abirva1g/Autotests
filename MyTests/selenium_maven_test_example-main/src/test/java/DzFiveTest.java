import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


@DisplayName(value = "Домашнее задание - Урок 5: JUnit:Утверждения")
public class DzFiveTest {
    WebDriver driver;

        @BeforeEach
        public void initDriver() {
            //Объявление драйвера браузера
            driver = new ChromeDriver();
        }

        @BeforeEach
        public void openStend() {
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
        @AfterEach
        public void closeDriver() {
            //Закрытие браузера
            driver.quit();
        }
    @Test
    @DisplayName(value = "Создание заметки")
    public void createNoteTest(){
        //Объявляем WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Клик по кнопке Создание заметки
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'Card_container')][1]"))).click();
       //Заполнение Заголовка заметки
        driver.findElement(By.xpath("//div[contains(@id,'note-modal-title')][1]")).sendKeys("Заметка номер 1");
        //Заполнение Содержания заметки
        driver.findElement(By.xpath("//div[contains(@id,'note-modal-content')][1]")).sendKeys("Содержание к заметке номер 1");
        //Нажатие на палитру
        driver.findElement(By.id("palette-btn-new_empty")).click();
        //Выбор цвета заметки
        driver.findElement(By.xpath("//div[contains(@id,'#fdcfe8')][1]")).click();
        //Нажатие кнопки Ок
        driver.findElement(By.id("note-modal-save-btn-new_empty")).click();
        //Сохранение значения из заголовка
        String titleText = driver.findElement(By.xpath("//p[contains(@id,'note-title')][1]")).getText();
        //Сравнение
        Assertions.assertEquals("Заметка номер 1",titleText, "Неверный заголовок заметки");
    }
    @Test
    @DisplayName(value = "Содержание заметки")
    public void checkNoteTextTest() {
        //Сохранение значения из содержания
        String contentText = driver.findElement(By.xpath("//div[contains(@class,'Card_body')][1]")).getText();
        //Сравнение
        Assertions.assertEquals("Содержание к заметке номер 1",contentText, "Неверное описание заметки");
    }
    @Test
    @DisplayName(value = "Цвет заметки")
    public void checkNoteColorTest() {
        //Сохранение цвета заметки
        String colorNote = driver.findElement(By.xpath("//div[contains(@id,'note-container')][1]")).getCssValue("background-color");
        //Сравнение
         Assertions.assertEquals("rgba(253, 207, 232, 1)",colorNote,"Неверный цвет заметки");
    }
    }




