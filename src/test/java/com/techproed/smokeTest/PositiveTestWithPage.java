package com.techproed.smokeTest;

import com.techproed.pages.CrystalHotelPages;
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

        CrystalHotelPages crystalHotelPages = new CrystalHotelPages(driver);
        crystalHotelPages.logIn.click();
        crystalHotelPages.userTextBox.sendKeys("manager");
        crystalHotelPages.passwordTextBox.sendKeys("Manager2!");
        crystalHotelPages.loginButton.submit();
        Thread.sleep(5000);
    }
}
