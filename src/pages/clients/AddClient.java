package pages.clients;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void setBirthDateJS(String clientBirthdate)
    {
       // birthDate.sendKeys(clientBirthdate);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value','"+clientBirthdate+"')",birthDate);

    }


    public void setBirthDate(String setDateStr) throws ParseException {
       birthDate.click();
       Date setDate = new SimpleDateFormat("MM/dd/yyyy").parse(setDateStr); // 12/21/2020

       String currDateStr = driver.findElement(By.className("datepicker-switch")).getText();
       // November 2020 --> MMMM yyyy
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);

         int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),
                 new DateTime(setDate).withDayOfMonth(1)).getMonths();

        System.out.println(monthDiff);
        boolean isFuture = true;

        if(monthDiff<0) {
            isFuture = false;

            monthDiff = monthDiff * (-1);
        }

        for(int i=0 ;i<monthDiff;i++)
        {
            if(isFuture)
                driver.findElement(By.className("next")).click(); // cilck next
            else
                driver.findElement(By.className("prev")).click(); // cilck prev
        }


        String setDateDayStr = new SimpleDateFormat("dd").format(setDate); // 21

int setDateDay = Integer.parseInt(setDateDayStr);

        driver.findElement(By.xpath("//td[text()='"+setDateDay+"' and @class='day']")).click();

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
