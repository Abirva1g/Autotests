import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ImplicitlyTest {
    WebDriver driver = new ChromeDriver();
    @Test
    @DisplayName(value = "Тест входа и клика по заметке 2")
    public void waitElement2(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Открытие стенда
        driver.get("http://172.24.120.5:8081/login");
        //Ввод логина
        driver.findElement(By.id("login-input")).sendKeys("test");
        //Ввод пароля
        driver.findElement(By.id("password-input")).sendKeys("test");
        //Клик по кнопке Войти
        driver.findElement(By.id("form_auth_button")).click();
        //Клик по заголовку заметки
        driver.findElement(By.xpath("//p[contains(@id,'note-title')][1]")).click();
        //Открытие стенда
        driver.get("http://172.24.120.5:8081/login");
        //Ввод логина
        driver.findElement(By.id("login-input")).sendKeys("test");
        //Ввод пароля
        driver.findElement(By.id("password-input")).sendKeys("test");
        //Клик по кнопке Войти
        driver.findElement(By.id("form_auth_button")).click();
        //Клик по заголовку заметки
        driver.findElement(By.xpath("//p[contains(@id,'note-title')][1]")).click();
    }
}
