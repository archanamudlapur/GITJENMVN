package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;

public class HomePageTest extends TestBase {
    LoginPage loginpage;
    HomePage homepage;
    LandingPage lp;
    ContactsPage contactspage;


    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void SetUp(){
        initialization();
        lp=new LandingPage();
        loginpage=new LoginPage();
        loginpage = lp.VerifyLogin();
        homepage=new HomePage();
        homepage = loginpage.VerifyHomePage(prop.getProperty("username"), prop.getProperty("password") );


    }
    @Test(priority = 1)
    public void ValidateHomePageTitle(){
     String HT= homepage.GetHomeTitle();
       Assert.assertEquals(HT,"Cogmento CRM","Incorrect Title");
        System.out.println(HT);
    }

   @Test(priority = 2)
   public void ValidateAddContactpageTest(){
       contactspage= homepage.AddContactPage();
   }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
