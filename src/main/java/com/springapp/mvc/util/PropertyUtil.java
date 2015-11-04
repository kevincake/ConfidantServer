package com.springapp.mvc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by andy.wu
 */
public class PropertyUtil {
    public static Properties getProperties(String fileName){
        Properties prop = new Properties();
        FileInputStream fis =
                null;
        try {
            fis = new FileInputStream("sample.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
