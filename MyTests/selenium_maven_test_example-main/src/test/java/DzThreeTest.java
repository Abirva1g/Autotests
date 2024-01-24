import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;

@DisplayName(value = "Домашнее задание - Урок 3: JUnit:Аннотации")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DzThreeTest {
    WebDriver driver;

    @BeforeAll
    public static void text1() {
        //Вывод текста до запуска тестов
        System.out.println("Начало тестирования");
    }
    @BeforeEach
    public void initDriver() {
        //Объявление драйвера браузера
        driver = new ChromeDriver();
    }
    @BeforeEach
    public void openStend() {
        //Открытие стенда
        driver.get("http://172.24.120.5:8081/login");
    }
    @AfterAll
    public static void text2() {
        //Вывод текста после всех тестов
        System.out.println("Окончание тестирования");
    }
    @AfterEach
    public void closeDriver() {
        //Закрытие браузера
        driver.quit();
    }
    @Test
    @Order(1)
    @DisplayName(value = "Регистрация")
    public void registrationTest(){
            //Кликаем на нопку Зарегистрироваться
            driver.findElement(By.id("form_register_button")).click();
            //Ввести значение в поле Логин
            driver.findElement(By.xpath("//input[@placeholder='Логин']")).sendKeys("ASSEROV");
            //Ввести значение в поле Пароль
            driver.findElement(By.xpath("//input[@placeholder='Пароль']")).sendKeys("Qwerty$4");
            //Кликаем по кнопке Создать
            driver.findElement(By.xpath("//button[text()='Создать']")).click();
        }

    @Test
    @Order(2)
    @DisplayName(value = "Авторизация")
    public void loginTest() {
        //Ввести значение в поле Логин
        driver.findElement(By.id("login-input")).sendKeys("ASSEROV");
        //Ввести значение в поле Пароль
        driver.findElement(By.id("password-input")).sendKeys("Qwerty$4");
        //Кликаем по кнопке Войти
        driver.findElement(By.id("form_auth_button")).click();
    }
    }

