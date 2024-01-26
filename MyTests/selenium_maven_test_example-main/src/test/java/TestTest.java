import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.junit.Test;
public class TestTest {

    @Test
    public void testTrue1()
    {
        Assertions.assertTrue(true);
    }

    @Test
    public void testTrue2()
    {
        Assertions.assertTrue(false, "Test execution result");
    }

    @Test
    public void testFalse1()
    {
        boolean falseBool = false;
        Assertions.assertFalse(falseBool);
    }

    @Test
    public void testFalse2()
    {
        boolean trueBool = true;
        String message = "Test execution result";
        Assertions.assertFalse(trueBool, message);
    }
}
