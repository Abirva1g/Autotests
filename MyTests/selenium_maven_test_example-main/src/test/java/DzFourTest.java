import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
@DisplayName(value = "Домашнее задание - Урок 4: Ожидания")
public class DzFourTest {
    WebDriver driver;

    @BeforeEach
    public void initDriver() {
        //Объявление драйвера браузера
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void openStend() {
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
    @DisplayName(value = "Тест клика по корзине (неявное)")
    public void waitTrash1() {
        //Объявляем неявное ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Клик по кнопке Корзина
        driver.findElement(By.id("trash-btn")).click();
    }

    @Test
    @DisplayName(value = "Тест клика по корзине явное)")
    public void waitTrash2() {
        //Объявляем WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Клик по кнопке Корзина
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("trash-btn"))).click();
    }
}
