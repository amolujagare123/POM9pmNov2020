package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

   /* WebDriver driver;

    WebElement txtUser = driver.findElement(By.xpath("//input[@id='email']"));
    */

    @FindBy (xpath = "//input[@id='email']")
    WebElement txtUsername;

    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy (xpath = "//a[@class='btn btn-default']")
    WebElement lnkForgotPass;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickForgotPassword()
    {
        lnkForgotPass.click();
    }


    public void setTxtUsername(String user)
    {
        txtUsername.sendKeys(user);
    }

    public void setTxtPassword(String pass)
    {
        txtPassword.sendKeys(pass);
    }

    public void clickLogin()
    {
        btnLogin.click();
    }
}
