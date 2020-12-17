package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D17_HotelRoomCreation extends TestBase {

    //. Tests packagenin altına class olusturun: HotelRoomCreation
    //2
    //. Bir metod olusturun:.
    @Test
    public void roomCreateTest() throws InterruptedException {


        //. qa environment.crystalkeyhotels.com adresine gidin.
        driver.get("http://qa-environment.crystalkeyhotels.com");

        //. Username textbox ve password metin kutularını locate edin ve aşağıdaki
        //verileri girin Username : manager2 b . Password :Login butonuna

        driver.findElement(By.linkText("Log in")).click();
        //test data username: manager ,
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys("manager");

        //test data password : Manager2!
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!"+ Keys.ENTER);
        //. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Hotel Management']")).click();
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
        //. Açılan sayfadaki tüm metin kutularına istediğiniz verileri
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[@class='hidden-480']")).click();

        WebElement dropDownElementiHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(dropDownElementiHotel);
        select.selectByVisibleText("Austin hotel");
        WebElement codeTextBox=driver.findElement(By.id("Code"));

        Actions actions=new Actions(driver);
        actions.click(codeTextBox)
                .sendKeys("210")
                .sendKeys(Keys.TAB)
                .sendKeys("grootkamer")
                .sendKeys(Keys.TAB)
                .sendKeys("Duitsland")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys("cok guzel oda")
                .perform();


        WebElement tasinacakElement = driver.findElement(By.linkText("300"));
        WebElement tasimaHedefElement = driver.findElement(By.id("Price"));
        actions.dragAndDrop(tasinacakElement,tasimaHedefElement).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement dropDownElementiRoom = driver.findElement(By.id("IDGroupRoomType"));
        Select select1 = new Select(dropDownElementiRoom);
        select1.selectByValue("318");
        WebElement maxAdultCount = driver.findElement(By.id("MaxAdultCount"));
        maxAdultCount.sendKeys("2");
        WebElement maxChildrenCount = driver.findElement(By.id("MaxChildCount"));
        maxChildrenCount.sendKeys("4");

        Thread.sleep(5000);

        WebElement radioButton = driver.findElement(By.id("IsAvailable"));
        radioButton.click();

        driver.findElement(By.id("btnSubmit")).click();

        Thread.sleep(10000);
        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//*[text()='HotelRoom was inserted successfully']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());
        //10. OK butonuna tıklayın.
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //11. Hotel rooms linkine tıklayın.
        actions.sendKeys(Keys.HOME).perform();
        driver.findElement(By.partialLinkText("Hotel Rooms")).click();
        //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        WebElement hotelRoomListYaziElementi=driver.findElement(By.xpath("(//*[text()='List Of Hotelrooms'])[2]"));
        Assert.assertTrue(hotelRoomListYaziElementi.isDisplayed());
    }
}
