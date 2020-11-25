package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    static Properties getLodedPropertiesObject() throws IOException {

        FileInputStream fp = new FileInputStream("resourses\\config.properties");

         Properties prop = new Properties();

         prop.load(fp);

         return prop;

    }

    public static String getUrl() throws IOException {

       return getLodedPropertiesObject().getProperty("url");
    }


}
