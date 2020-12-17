package com.techproed.tests;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D14_AmazonTest extends TestBase {


    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com/");

        WebElement bekleGor = driver.findElement(By.id("nav-link-accountList"));

        Actions actions = new Actions(driver);

        actions.moveToElement(bekleGor).perform();
        Thread.sleep(5000);

        WebElement list = driver.findElement(By.linkText("Create a Lists"));
        actions.click(list).perform();
        Thread.sleep(5000);

        WebElement sonucYazisi = driver.findElement(By.linkText("Your Lists"));
        Assert.assertEquals(sonucYazisi.getText(),"Your Lists");

    }

}
