package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;

public class LoginTest extends OpenUrl {


    @Test
    public void logintest() throws IOException {

        Login login = new Login(driver);

        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();

    }

}
