package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(xpath = "//a[normalize-space()='Dashboard']")
    WebElement lnkDashboard;

    @FindBy (xpath = "//span[normalize-space()='Clients']")
    WebElement clients;

    @FindBy (xpath = "//a[normalize-space()='Add Client']")
    WebElement addClient;

    @FindBy (xpath = "//a[normalize-space()='View Clients']")
    WebElement viewClient;

    @FindBy (xpath = "//span[normalize-space()='Quotes']")
    WebElement quotes;

    @FindBy (xpath = "//a[normalize-space()='Create Quote']")
    WebElement createQuote;

    @FindBy (xpath = "//a[normalize-space()='View Quotes']")
    WebElement viewQuote;

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickLnkDashboard()
    {
        lnkDashboard.click();
    }

    public void clickAddClient()
    {
        clients.click();
        addClient.click();
    }

    public void clickViewClient()
    {
        clients.click();
        viewClient.click();
    }

    public void clickCreateQuote()
    {
        quotes.click();
        createQuote.click();
    }

    public void clickViewQuotes()
    {
        quotes.click();
        viewQuote.click();
    }
}
