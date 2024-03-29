

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;

@DisplayName(value= "Регистрация на тестовом стенде")
public class ThirdSuiteTest {
    WebDriver driver;
    @BeforeEach
    public void intiDriver() {
        driver = new ChromeDriver();
    }
    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
    @Test
    @DisplayName(value = "Тест регистрации")
    public void registrationTest(){
        //Открытие стенда
        driver.get("http://172.24.120.5:8081/login");
        //Кликаем на нопку Зарегистрироваться
        driver.findElement(By.id("form_register_button")).click();
        //Ввести значение в поле Логин
        driver.findElement(By.xpath("//input[@placeholder='Логин']")).sendKeys("login1");
        //Ввести значение в поле Пароль
        driver.findElement(By.xpath("//input[@placeholder='Пароль']")).sendKeys("passTest");
        //Кликаем по кнопке Создать
        driver.findElement(By.xpath("//button[text()='Создать']")).click();
    }
}


