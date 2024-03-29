// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class Dz1LoginSeleniumIDETest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void loginSeleniumIDE() {
    driver.get("http://172.24.120.5:8081/login");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.id("login-input")).click();
    driver.findElement(By.id("login-input")).sendKeys("SeleniumIDE");
    driver.findElement(By.id("root")).click();
    driver.close();
  }
}
