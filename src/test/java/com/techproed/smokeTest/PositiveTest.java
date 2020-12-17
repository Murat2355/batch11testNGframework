package com.techproed.smokeTest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

        //1) com.techproed altinda bir package olustur : smoketest
        //2) Bir Class olustur : PositiveTest
        //3) Bir test method olustur positiveLoginTest()

    @Test
    public void positiveLoginTest(){

        //   http://qa-environment.crystalkeyhotels.com adresine git
        driver.get("http://qa-environment.crystalkeyhotels.com");
        //  login butonuna bas
        driver.findElement(By.linkText("Log in")).click();
        //test data username: manager ,
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys("manager");

        //test data password : Manager2!
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!"+ Keys.ENTER);

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        WebElement addUser = driver.findElement(By.xpath("//*[.='Add User ']"));
        Assert.assertTrue(addUser.isDisplayed());

    }


}
