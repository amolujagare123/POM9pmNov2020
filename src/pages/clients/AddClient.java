package pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath = "//input[@id='client_name']")
    WebElement name;

    @FindBy (xpath = "//input[@id='client_surname']")
    WebElement surname;

    @FindBy (xpath = "//input[@id='client_address_1']")
    WebElement add1;

    @FindBy (xpath = "//input[@id='client_address_2']")
    WebElement add2;

    @FindBy (xpath = "//input[@id='client_city']")
    WebElement city;

    @FindBy (xpath = "//input[@id='client_state']")
    WebElement state;

    @FindBy (xpath = "//input[@id='client_zip']")
    WebElement zip;

    @FindBy (xpath = "//span[@id='select2-client_language-container']")
    WebElement containerLanguage;

    @FindBy (xpath = "//input[@type='search']")
    WebElement searchBox;

    @FindBy (xpath = "//input[@id='client_birthdate']")
    WebElement birthDate;

    public void setBirthDate(String clientBirthdate)
    {
       // birthDate.sendKeys(clientBirthdate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
      //  js.executeScript("window. scrollBy(0,500)");
        js.executeScript("arguments[0].setAttribute('value','"+clientBirthdate+"')",birthDate);

    }



    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language);
        driver.findElement(By.xpath("//li[contains(text(),'"+language+"')]")).click();
    }


    @FindBy (xpath = "//span[@id='select2-client_country-container']")
    WebElement containerCountry;

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();
    }

    @FindBy (xpath = "//span[@id='select2-client_gender-container']")
    WebElement containerGender;

    public void setGender(String gender)
    {
        containerGender.click();
        driver.findElement(By.xpath("//li[contains(text(),'"+gender+"')]")).click();
    }

    WebDriver driver;

    public AddClient(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }




    public void setName(String clientname)
    {
        name.sendKeys(clientname);
    }

    public void setSurname(String clientSurname)
    {
        surname.sendKeys(clientSurname);
    }

    public void setAdd1(String address)
    {
        add1.sendKeys(address);
    }

    public void setAdd2(String address)
    {
        add2.sendKeys(address);
    }

    public void setCity(String cilentCity)
    {
        city.sendKeys(cilentCity);
    }

    public void setState(String clientState)
    {
        state.sendKeys(clientState);
    }

    public void setZip(String zipcode)
    {
        zip.sendKeys(zipcode);
    }

}
