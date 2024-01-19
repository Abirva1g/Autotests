import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class FirstTest {

    @Test
    public void testGoogle() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.ru/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))).sendKeys("Selenium Test");
        driver.findElement(By.name("btnK")).click();
        driver.quit();
    }

}
