package DzSixteen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


public class DzTest extends BaseTest {
    @DisplayName(value = "Урок 16: Паттерны проектирования в автоматизации тестирования")
    @Test
    public void testCheckNote() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authorizationPage.goToAuthorizationPage();
        authorizationPage.fillInLogin("ASSEROV");
        authorizationPage.fillInPassword("Qwerty$4");
        authorizationPage.clickLoginButton();
        mainPage.clickNewNoteButton();
        mainPage.fillNoteTitle("Урок 16");
        mainPage.fillNoteContent("Page Object и Page Factory");
        mainPage.clickNoteModalChangeColor();
        mainPage.clickNoteModalColor();
        mainPage.clickNoteModalOkButton();
        Assertions.assertEquals("Урок 16", mainPage.getTextNote(), "Неверный заголовок заметки");
        Assertions.assertEquals("Page Object и Page Factory", mainPage.getTextContent(), "Неверное описание заметки");

    }
}