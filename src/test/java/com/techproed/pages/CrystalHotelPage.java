package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CrystalHotelPage {


    WebDriver driver;
    public CrystalHotelPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Log in")
    public WebElement logIn;

    @FindBy(id="UserName")
    public WebElement userTextBox;

    @FindBy(id="Password")
    public WebElement passwordTextBox;

    @FindBy(id="btnSubmit")
    public WebElement loginButton;


}
