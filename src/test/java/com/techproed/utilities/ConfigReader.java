package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //ilk yapacagimiz sey instance olarak properties Class'indan properties objesi olusturmak
    //Bu obje yi static block icerrisinde kullanacagimdan static yapmam gereiyor.
    //Bu objeyi sadece bu class da yapacagimiz icin private yapmamiz onerilir.
    private static Properties properties;

    //static block:her zaman ilk olarak static block calisir.
    static {
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
