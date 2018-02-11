package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public String getProperty(String path, String properties) throws IOException {
        Properties pro = new Properties();
        InputStream in = new FileInputStream(path);
        pro.load(in);
        return pro.getProperty(properties);
    }

}
