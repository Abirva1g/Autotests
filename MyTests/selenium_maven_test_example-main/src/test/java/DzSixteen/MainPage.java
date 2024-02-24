package DzSixteen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class,'Card_containerNew')]")
    private WebElement createNoteButton;

    @FindBy(xpath = "//div[contains(@id,'note-modal-title')]")
    private WebElement noteModalTitle;

    @FindBy(xpath = "//div[contains(@id,'note-modal-content')]")
    private WebElement noteModalContent;

    @FindBy(id = "palette-btn-new_empty")
    private WebElement noteModalChangeColor;

    @FindBy(xpath = "//div[contains(@id,'#fdcfe8')]")
    private WebElement noteModalColor;

    @FindBy(id = "note-modal-save-btn-new_empty")
    private WebElement noteModalOkButton;

    @FindBy(xpath = "//*[contains(@id,'note-container')][last()]//p")
    private WebElement lastTitle;

    @FindBy(xpath = "//*[contains(@id,'note-container')][last()]//div[contains(@class,'Card_body')]")
    private WebElement lastContent;


    public MainPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }


    public void clickNewNoteButton() {

        wait.until(ExpectedConditions.visibilityOf(createNoteButton)).click();
    }

    public void fillNoteTitle(String noteTitleText) {
        wait.until(ExpectedConditions.visibilityOf(noteModalTitle)).sendKeys(noteTitleText);
    }

    public void fillNoteContent(String noteContentText) {
        wait.until(ExpectedConditions.visibilityOf(noteModalContent)).sendKeys(noteContentText);
    }

    public void clickNoteModalChangeColor() {
        wait.until(ExpectedConditions.elementToBeClickable(noteModalChangeColor)).click();
    }

    public void clickNoteModalColor() {
        wait.until(ExpectedConditions.elementToBeClickable( noteModalColor)).click();
    }

    public void clickNoteModalOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(noteModalOkButton)).click();
    }


    public String getTextNote() {
        return lastTitle.getText();
    }

    public String getTextContent() {
        return lastContent.getText();
    }



    }



