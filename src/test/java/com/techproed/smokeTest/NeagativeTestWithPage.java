package com.techproed.smokeTest;

import com.techproed.pages.CrystalHotelPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class NeagativeTestWithPage extends TestBase {
    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest

    //       - yanlisSifre
    //2) "http://qa-environment.crystalkeyhotels.com"adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et    //*[.='Username or password is incorrect, please correct them and try again']

    @Test
    public void test(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        CrystalHotelPage crystalHotelPage = new CrystalHotelPage(driver);
        crystalHotelPage.logIn.click();
        crystalHotelPage.userTextBox.sendKeys("manager");
        crystalHotelPage.passwordTextBox.sendKeys("managers");
        crystalHotelPage.loginButton.click();
    }
}
