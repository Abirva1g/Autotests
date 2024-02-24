package DzSixteen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {
    private WebDriver driver;
    private String urlPage = "http://172.24.120.5:8081/login";
    @FindBy (id = "login-input")
    private WebElement loginTextField;
    @FindBy (id = "password-input")
    private WebElement passwordTextField;
    @FindBy (id = "form_auth_button")
    private WebElement loginButton;

    public AuthorizationPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void goToAuthorizationPage() {
        driver.get(urlPage);
        }

    public void fillInLogin (String loginText) {
    loginTextField.sendKeys(loginText);
    }
    public void fillInPassword (String passwordText) {
        passwordTextField.sendKeys(passwordText);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
}

