package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D16_SeleniumWaits extends TestBase {

    @Test
    public  void test1(){
        driver.get("https:\\www.youtube.com");

        WebElement logo = driver.findElement(By.xpath("(//div[@id=\"logo-icon-container\"])[1]"));

        //WebElement olmayanElement = driver.findElement(By.id("olmayan"));

    }

    @Test
    public void implicitlyWaitTest(){
        //1. Bir class olusturun : WaitTest
        //        2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //        Iki metod icin de asagidaki adimlari test edin.
        //        3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //        4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //        5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement sonucYaziElementi=driver.findElement(By.id("message"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        //        6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //        7. It’s back mesajinin gorundugunu test edin
        WebElement sonucYaziElementi2=driver.findElement(By.id("message"));
        Assert.assertTrue(sonucYaziElementi2.isDisplayed());
    }

    @Test
    public void explicitlyWait(){

        //        3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //        4. Remove butonuna basin.
        WebDriverWait wait = new WebDriverWait(driver,30);

        WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));
        removeButton.click();

        // WebElement removeButtonEski = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        WebElement itsGoneYazisiElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneYazisiElementi.isDisplayed());

        //        6. Add buttonuna basin

        removeButton.click();

        //        7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementiYazisi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackElementiYazisi.isDisplayed());
    }
}
