import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class DzTen {

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
    @DisplayName(value = "Домашнее задание - Урок 10-1: Java:Циклы")
    public void createEditNoteTest() {
        for (int i = 0; i < 3; i++) {

            //Объявляем WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Создание заметок
            //Клик по кнопке Создание заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Card_containerNew')]"))).click();
            //Заполнение Заголовка заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'note-modal-title')]"))).sendKeys("Заметка номер " + i);
            //Заполнение Содержания заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'note-modal-content')]"))).sendKeys("Содержание к заметке номер " + i);
            //Нажатие на палитру
            wait.until(ExpectedConditions.elementToBeClickable(By.id("palette-btn-new_empty"))).click();
            //Выбор цвета заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'#fdcfe8')]"))).click();
            //Нажатие кнопки Ок
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-save-btn-new_empty"))).click();
            //Рефреш страницы
            driver.navigate().refresh();

            //Получаем ид последнего контейнера заметок
            String lastId = driver.findElement(By.xpath("//*[contains(@id,'note-container')][last()]")).getAttribute("id");
            //Обрезаем ид заметки
            lastId = lastId.substring(15);
            //Поиск заголовка последней заметки
            String titleText = driver.findElement(By.id("note-title-" + lastId)).getText();
            //Поиск содержания последнего контейнера заметки
            String contentText = driver.findElement(By.id("note-content-"+ lastId)).getText();
            //Убираем строчку с заголовком заметки
            String noteContentText = contentText.substring(contentText.indexOf("\n")+1);
            System.out.printf("ДО: Название:%s\tОписание:%s\n",titleText, noteContentText);

            // Редактирование заметки
            //Рефреш страницы
            driver.navigate().refresh();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("note-edit-btn-" + lastId))).click();
            //Очищение заголовка заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-title-" + lastId))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-title-" + lastId))).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-title-" + lastId))).sendKeys("Новый заголовок заметки номер " + i);
            //Изменение содержания заметки
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-content-" + lastId))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-content-" + lastId))).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-content-" + lastId))).sendKeys("Новое содержание к заметке номер " + i);
            //Нажатие кнопки Ок
            wait.until(ExpectedConditions.elementToBeClickable(By.id("note-modal-save-btn-"+ lastId))).click();
            //Рефреш страницы
            driver.navigate().refresh();
            titleText = driver.findElement(By.id("note-title-" + lastId)).getText();
            //Поиск содержания последнего контейнера заметки
            contentText = driver.findElement(By.id("note-content-"+ lastId)).getText();
            //Убираем строчку с заголовком заметки
            noteContentText = contentText.substring(contentText.indexOf("\n")+1);
            System.out.printf("ПОСЛЕ: Название:%s\tОписание:%s\n",titleText, noteContentText);
        }
    }
    @AfterEach
    public void closeDriver() {
        //Закрытие браузера
        driver.quit();
    }
}