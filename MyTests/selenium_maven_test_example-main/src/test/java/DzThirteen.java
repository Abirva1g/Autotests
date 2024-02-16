import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;



@DisplayName(value = "Домашнее задание - Урок 13: Java:Исключения")
public class DzThirteen {
    WebDriver driver;

    @BeforeEach
    public void openStendInitDriver() {
        //Объявление драйвера браузера
        driver = new ChromeDriver();
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
    @DisplayName(value = "Обработка исключения")
    public void createNoteTest() {
        //Объявляем WebDriverWait с ожиданием 0,01 сек
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));
        //Клик по кнопке Создание заметки
        try {
            // Попытка найти кнопку Создание заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Card_containerNew')]"))).click();
            }
        catch (TimeoutException num) {
            // Обработка исключения, если кнопка не нашлась
            System.out.println("Кнопка Создание заметки не был найдена в течение заданного времени ожидания");
        }
        // Закрыть браузер после выполнения теста
        finally {
            driver.quit();
        }
    }
}