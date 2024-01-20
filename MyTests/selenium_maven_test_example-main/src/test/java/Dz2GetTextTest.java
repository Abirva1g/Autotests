import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dz2GetTextTest {

    @Test
    public void GetText() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://172.24.120.5:8081/login");
        driver.manage().window().setSize(new Dimension(1552, 840));
        String formAuthBlockHeadText = driver.findElement(By.className("form_auth_block_head_text")).getText();
        driver.findElement(By.id("login-input")).sendKeys(formAuthBlockHeadText);
        String loginValueText = driver.findElement(By.id("login-input")).getAttribute("value");
        driver.findElement(By.id("password-input")).sendKeys(loginValueText);
        driver.findElement(By.id("password-input")).clear();
        String cssValueButton = driver.findElement(By.id("form_auth_button")).getCssValue("width");
        driver.findElement(By.id("password-input")).sendKeys(cssValueButton);
    }

}
