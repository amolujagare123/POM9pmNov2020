package regression.clients;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;
import util.OpenUrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class AddClientTest extends DoLogin
{
    @Test (dataProvider = "getData")
    public void addClientTest(String name,String surname,String add1,
                              String add2,String city,String state,
                              String zip,String phone,String fax,
                              String mobile,String email,String web,
                              String tax,String vat,String birthdate,
                              String language,String country,String gender,
    String expected, String xpathActual) throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClients = new AddClient(driver);

        addClients.setClientName(name);
        addClients.setSurname(surname);
        addClients.setAddress1(add1);
        addClients.setAddress2(add2);
        addClients.setCity(city);
        addClients.setState(state);
        addClients.setZip(zip);
        addClients.setPhone(phone);
        addClients.setFax(fax);
        addClients.setMobile(mobile);
        addClients.setEmail(email);
        addClients.setWeb(web);
        addClients.setTax(tax);
        addClients.setVat(vat);
        addClients.setBirthDate(birthdate); // dd/MM/yyyy
        addClients.setlanguage(language);
        addClients.setCountry(country);
        addClients.setGender(gender);
        addClients.clickSave();

        String actual ="";
        try {
             actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        Assert.assertEquals(actual,expected,"wrong message:"+actual);


    }

    @DataProvider
    public Object[][] getData() throws IOException {

        FileInputStream fp = new FileInputStream("Data\\ip.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][20];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<20;j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = cell.toString().trim();
            }
        }

        return data;
    }


}
