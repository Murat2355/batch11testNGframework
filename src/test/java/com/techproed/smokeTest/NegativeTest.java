package com.techproed.smokeTest;

import com.github.javafaker.Faker;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {

    //1) smokeTest paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    //       - yanlisSifre
    //       - yanlisKulllanici
    //       - yanlisSifreKullanici
    //2) "http://qa-environment.crystalkeyhotels.com"adresine git
    //3) Login butonuna bas
    //4) Verilen senaryolar ile giris yapilamadigini test et    //*[.='Username or password is incorrect, please correct them and try again']

    Faker faker = new Faker();
    public void giris(){
        driver.get("http://qa-environment.crystalkeyhotels.com");
        driver.findElement(By.linkText("Log in")).click();

    }


    @Test
    public void yanlisSifreTest(){


        giris();
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys("manager");
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        String sifre = faker.internet().password();
        passwordTextBox.sendKeys(sifre+ Keys.ENTER);
        WebElement tryMessage = driver.findElement(By.xpath("//*[.='Username or password is incorrect, please correct them and try again']"));
        Assert.assertTrue(tryMessage.isDisplayed());
    }

    @Test
    public void yanlisKullaniciAdiTest(){
        giris();
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys(faker.name().firstName());
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!"+Keys.ENTER);
        WebElement tryMessage = driver.findElement(By.xpath("//*[.='Username or password is incorrect, please correct them and try again']"));
        Assert.assertEquals(tryMessage.getText(),"Username or password is incorrect, please correct them and try again");
    }
    @Test
    public void yanlisKullaniciAdiSifreTest(){
        giris();
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys(faker.name().firstName());
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        String sifre = faker.internet().password();
        passwordTextBox.sendKeys(sifre+ Keys.ENTER);
        WebElement girilemediUyarisiWebElementi=driver.findElement(By.xpath("//*[text()='Try again please']"));
        Assert.assertEquals(girilemediUyarisiWebElementi.getText(),"Try again please");
    }
}
