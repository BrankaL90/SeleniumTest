package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By emailField = By.cssSelector("input[data-test='email']");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");

    private By signIn = By.xpath("//div[@id='navbarSupportedContent']/ul/li[4]/a");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginUser(String username, String password){
        clickOnElement(signIn);
        typeIn(emailField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);
        return this;
    }


}