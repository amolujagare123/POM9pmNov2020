package regression.clients;

import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;
import util.OpenUrl;

public class AddClientTest extends DoLogin
{
    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        /*addClient.setName("amol");
        addClient.setSurname("Ujagare");
        addClient.setAdd1("abcd");
        addClient.setAdd2("1234");
        addClient.setCity("pune");
        addClient.setState("Maharashtra");
        addClient.setZip("4140001");*/

        /*addClient.setLanguage("Thai");

        addClient.setCountry("Hungary");

        addClient.setGender("Other");*/

        addClient.setBirthDate("12/21/2020");
    }
}
