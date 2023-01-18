package com.crm.qa.pages;


import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends TestBase {


    @FindBy(xpath ="//span[contains(text(),'Log In')]")
    WebElement loginbtn;
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signupbtn;
    @FindBy(xpath = "//a[contains(text(),'CRM')]")
    WebElement CRMbtn;

    public LandingPage(){
        PageFactory.initElements(driver,this);
    }

    //public String LandTitle(){

       // return driver.getTitle();
   // }

    public LoginPage VerifyLogin(){
        loginbtn.click();
        return new LoginPage();
    }

    public SignUpPage VerifySignUp(){
        signupbtn.click();
        return new SignUpPage();
    }
    public void VerifyCRMBtn(){
        TestUtil testutil=new TestUtil();
       testutil.ActionOnElement();

    }


}
