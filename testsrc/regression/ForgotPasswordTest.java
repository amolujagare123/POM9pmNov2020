package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;

public class ForgotPasswordTest extends OpenUrl {

    @Test
    public void forgotPassTest() throws IOException {

        Login login = new Login(driver);
        login.clickForgotPassword();

        ForgotPassword forgotPassword =new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@gmail.com");
        forgotPassword.clickReset();


    }
}
