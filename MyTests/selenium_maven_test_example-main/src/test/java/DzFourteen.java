import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class DzFourteen {
    WebDriver driver;
    @DisplayName(value = "Домашнее задание - Урок 14: JavaScript в тестах")
    @Test
    public void jsExecutor() {
        //Объявление драйвера браузера
        driver = new ChromeDriver();
        //Объявляем WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Создание объекта интерфейса JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Развернуть окно на весь экран
        driver.manage().window().maximize();
        //Открытие стенда
        driver.get("http://172.24.120.5:8081/login");
        // Ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Ввод логина
        driver.findElement(By.id("login-input")).sendKeys("ASSEROV");
        //Ввод пароля
        driver.findElement(By.id("password-input")).sendKeys("Qwerty$4");
        //Путь до кнопки войти
        WebElement button = driver.findElement(By.id("form_auth_button"));
        //Клик по кнопке Войти
        js.executeScript("arguments[0].click()",button);
        // Путь по кнопке Swagger
        WebElement buttonSwagger = driver.findElement(By.xpath("//a[text()='Swagger']"));
        //атрибут href из кнопки перехода в Swagger
        String href =  js.executeScript("return arguments[0].getAttribute('href');", buttonSwagger).toString();
        //Переход на сайт лиги
        js.executeScript("window.location = 'https://www.digitalleague.ru/'");
        //открытие в новой вкладке сваггера
        js.executeScript("window.open(arguments[0]);", href);
        //список вкладок
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //переключение на вторую вкладку
        driver.switchTo().window(tabs.get(1));
        // ожидание прогрузки страницы сваггера
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'topbar']")));
        //скролл до конца страницы
        js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
    }
}
