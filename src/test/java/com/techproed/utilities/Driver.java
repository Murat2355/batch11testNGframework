package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Singleton Class  : Obje olusturulmasi kontrol altina alinan(genelde izin verilmeyen) class'dir.Bu sart degildir.
    //Bunun icin baska classlarda Driver class'indan obje uretmemizi saglayan default constructor'i
    //gorunur sekilde yazip access modifier'i private yapariz.
    private Driver(){

    }

    static  private WebDriver driver;

    static public WebDriver getDriver(){

        if(driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                case "opera":
                    WebDriverManager.getInstance(OperaDriver.class);
                    driver = new OperaDriver();
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    static public void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }

}
