package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.SignUpPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPageTest extends TestBase {
    SignUpPage signup;

    HomePage homepage;
    LandingPage lp;
    public SignUpPageTest(){
        super();
    }

    @BeforeMethod
    public void SetUp() {
        initialization();
        signup=new SignUpPage();
        lp=new LandingPage();
       signup= lp.VerifySignUp();


    }
    @Test(priority = 1)
    public void ValidateSignTitleTest(){
      String RT1=  signup.RegTitle();
      System.out.println(RT1);
    }

    //@Test(priority = 2)
   // public void ValidateSignUpTest(){
   // signup.RegSignUp(prop.getProperty("username"));
   // }


    @AfterMethod
   public void teardown(){
       driver.quit();
    }
}
