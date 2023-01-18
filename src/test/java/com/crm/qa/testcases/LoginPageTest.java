package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LandingPage lp;
    LoginPage loginpage;
    HomePage homepage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void SetUp(){
        initialization();
        lp=new LandingPage();
        loginpage=new LoginPage();
      loginpage = lp.VerifyLogin();
    }

    @Test(priority = 2)
    public void ValidateHomepageTest(){
      homepage = loginpage.VerifyHomePage(prop.getProperty("username"), prop.getProperty("password") );
    }
    @Test(priority = 1)
    public void LoginTitleTest(){
       String S1= loginpage.VerifyLoginTitle();
       System.out.println(S1);
       Assert.assertEquals(S1,"Cogmento CRM");

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
