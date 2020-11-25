package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        // read the value of url present in the config.properties file

        // steps to read the value of a key in a properties file
        //------------------------------------------------
        // 1. create the file object

        FileInputStream fp = new FileInputStream("resourses\\config.properties");

        //------------------------------------------------
        // 2. create the object of properties file
        Properties prop = new Properties();

        //------------------------------------------------
        // 3. load the the file object using properties object
        prop.load(fp);

        //------------------------------------------------
        // 4. read the value using getProperty method
        String myUrl = prop.getProperty("url");

        System.out.println("url is :"+myUrl);


    }

}
