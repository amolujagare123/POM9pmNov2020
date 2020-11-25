package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Driver {

    private static WebDriver driver;
    public static enum DriverType
    {
        CHROME, FIREFOX , INTERNEREXPLORER
    }

    public static WebDriver getMyDriver(DriverType d)
    {
        switch (d)
        {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case INTERNEREXPLORER:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
        }

        return  driver;
    }

}
