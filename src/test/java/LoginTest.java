import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LoginPage login;

    @BeforeMethod
    public void setupLogin()
    {login = new LoginPage(driver);}

    @Test

    public void successfullLogin(){

        login.loginUser("username@gmail.com", "password");




    }

    @Test

    public void loginWithWrongPassword(){

        login.loginUser("username@gmail.com", "password");
        WebElement result = driver.findElement(By.cssSelector(".help-block"));
        String actual = result.getText();
        String expected = "Invalid email or password";


        Assert.assertEquals(actual,expected);


    }

    @Test

    public void loginWithWrongEmail(){

    }


}
