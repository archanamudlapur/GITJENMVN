package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath ="//input[contains(@name,'email')]")
    WebElement Username;
    @FindBy(xpath="//input[contains(@name,'password')]")
    WebElement Password;
    @FindBy(xpath="//div[contains(text(),'Login')]")
    WebElement LoginBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String VerifyLoginTitle(){
       return driver.getTitle();
    }

    public HomePage VerifyHomePage(String un,String pass){
        Username.sendKeys(un);
        Password.sendKeys(pass);
        LoginBtn.click();
        return new HomePage();
    }
}
