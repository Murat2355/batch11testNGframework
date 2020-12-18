package com.techproed.tests;

import com.techproed.pages.FaceBookPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class D20_FacebookPOM extends TestBase {

    @Test
    public  void test1(){
        driver.get("https://www.facebook.com/");
        WebElement userTextBox = driver.findElement(By.id("email"));
        userTextBox.sendKeys("");
        WebElement passwordTextBox = driver.findElement(By.id("pass"));
        passwordTextBox.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("u_0_b"));
        loginButton.click();

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        //1.adimdak ihedef locator'lerden kurtulmak
        // bunun icin pages paketi altindaki ilgili page'de ihtiyac duydugum tum lacate islemlerini yapip
        // burada sadece kullanacagim

        FaceBookPage faceBookPage = new FaceBookPage(driver);
        faceBookPage.userTextBox.sendKeys("mehmet@gmail.com");
        faceBookPage.passwordTextBox.sendKeys("123456");
        faceBookPage.loginButton.submit();

        Thread.sleep(5000);




    }
    @Test
    public void test3(){
        driver.get(ConfigReader.getProperty("facebook_url"));
        FaceBookPage faceBookPage = new FaceBookPage(driver);
        faceBookPage.userTextBox.sendKeys("mehmet@gmail.com");
        faceBookPage.passwordTextBox.sendKeys("123456");
        faceBookPage.loginButton.submit();
    }

}
