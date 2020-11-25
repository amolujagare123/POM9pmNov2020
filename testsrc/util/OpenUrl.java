package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import utilities.Driver;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;
import static utilities.Driver.*;

public class OpenUrl {

   public static WebDriver driver;

    @BeforeClass
    public void openUrl() throws IOException {

        driver = getMyDriver(DriverType.CHROME);

        driver.manage().window().maximize();
        driver.get(getUrl());
    }

}
