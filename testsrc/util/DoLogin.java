package util;

import org.testng.annotations.BeforeClass;
import pages.Login;

import java.io.IOException;

public class DoLogin extends  OpenUrl{


    @BeforeClass
    public void doLogin() throws IOException {

        Login login = new Login(driver);

        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();

    }
}
