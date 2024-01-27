import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
@DisplayName(value = "Тест проверка заголовки заметки")
public class AssertionsTest {
    WebDriver driver;
    @Test
    public void checkTitleTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Открытие стенда
        driver.get("http://172.24.120.5:8081/login");
        //Ввод логина
        driver.findElement(By.id("login-input")).sendKeys("test");
        //Ввод пароля
        driver.findElement(By.id("password-input")).sendKeys("test");
        //Клик по кнопке Войти
        driver.findElement(By.id("form_auth_button")).click();
        String titleText = driver.findElement(By.xpath("//p[contains(@id,'note-title')][1]")).getText();
        Assertions.assertEquals("Заметка",titleText, "Неверный заголовок заметки");
    }
}
