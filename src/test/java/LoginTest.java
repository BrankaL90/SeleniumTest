import DataProviders.DataProviders;
import Pages.LoginPage;
import Pages.RegisterPage;
import listeners.TestListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)

public class LoginTest extends BaseTest {

    LoginPage login;
    RegisterPage registerPage;


    @BeforeMethod
    public void loginSetup() {
        login = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }


    @Test
    public void loginUserTest() {
        login.goToLoginForm()
                .loginUser("customer@practicesoftwaretesting.com", "welcome01");
        Assert.assertTrue(registerPage.isUserRegisteredAndLoggedIn());
    }

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviders.class)
    public void invalidLogIn(String username, String password){
        login.goToLoginForm()
                .loginUser(username,password);
        Assert.assertTrue(login.isErrorMessagePresent());
    }
}
