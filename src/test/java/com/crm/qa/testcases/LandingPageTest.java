package com.crm.qa.testcases;

import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingPageTest extends TestBase {

    LandingPage lp;
    LoginPage loginpage;
    SignUpPage signuppage;

    public LandingPageTest() {
        super();
    }

    @BeforeMethod
    public void Setup() {
        initialization();
         lp=new LandingPage();
    }


    @Test(priority = 1)
        public void ValidateLoginPageTest(){
        loginpage=lp.VerifyLogin();
    }

    @Test(priority = 2)
    public void ValidateSignUpTest(){
        signuppage=lp.VerifySignUp();
    }

    //@Test(priority = 3)
    //public void ValidatelandTitle(){
     //   lp .LandTitle();
    //}



    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}

