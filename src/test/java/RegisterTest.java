import Pages.LoginPage;
import Pages.RegisterPage;
import listeners.TestListeners;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListeners.class)

public class RegisterTest extends BaseTest{

    RegisterPage registerPage;
    LoginPage login;


    @BeforeMethod
    public void setupRegister(){
        registerPage = new RegisterPage(driver);
        login = new LoginPage(driver);
    }


    @Test
    public void registerTest(){
        registerPage.goToRegisterPage()
                .registerPage();

        login.loginUser(registerPage.getUsername(),registerPage.getPassword());

        Assert.assertTrue(registerPage.isUserRegistered());


    }

    @Test
    public void negativeRegisterTest(){

    }


}

