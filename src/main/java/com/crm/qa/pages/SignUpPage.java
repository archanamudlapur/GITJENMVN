package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends TestBase {
    @FindBy(xpath = "//input[contains(@name,'email')]")
    WebElement Email;
    @FindBy(xpath="//input[contains(@name,'terms')]")
    WebElement AgreeTerms;
    @FindBy(xpath = "//div[@role='presentation' and @class='recaptcha-checkbox-checkmark']")
    WebElement NotARoboCheck;
    @FindBy(xpath="//button[contains(text(),'Sign up')]")
    WebElement SignUpBtn;

    public SignUpPage(){
        PageFactory.initElements(driver,this);
    }

    public String RegTitle(){
       return driver.getTitle();
    }

    public void RegSignUp(String un){
        Email.sendKeys(un);
        AgreeTerms.click();
        NotARoboCheck.click();
        SignUpBtn.click();

    }






}
