package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {

    WebDriver driver;

    //1.adim parametre olaarak WebDriver driver kullnabilecegim. Constructor olusturmaliyim.
    public FaceBookPage(WebDriver driver){
    //driver'i bu sayfada kontrol edebilmek icin bu sayfada bir driver olusturmaliyim.
    //Olusturacagim bu driver'i instance olarak olusturuyorum ki class'in her yerinde kullanayaim diye
       this.driver=driver;
       PageFactory.initElements(driver,this);
    }

    @FindBy(id="email")
    public WebElement userTextBox;

    @FindBy(id="pass")
    public WebElement passwordTextBox;

    @FindBy(id="u_0_b")
    public WebElement loginButton;


}
