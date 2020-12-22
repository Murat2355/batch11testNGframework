package com.techproed.smokeTest;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class PositiveTestWithPage extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1) com.techproed altinda bir package olustur : smoketest
        //2) Bir Class olustur : PositiveTest
        //3) Bir test method olustur positiveLoginTest()
        //     http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");
        //    login butonuna bas
        //test data username: manager ,
        //test data password : Manager2!
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        CrystalHotelPage crystalHotelPage = new CrystalHotelPage(driver);
        crystalHotelPage.logIn.click();
        crystalHotelPage.userTextBox.sendKeys("manager");
        crystalHotelPage.passwordTextBox.sendKeys("Manager2!");
        crystalHotelPage.loginButton.submit();
        Thread.sleep(5000);
    }
}
