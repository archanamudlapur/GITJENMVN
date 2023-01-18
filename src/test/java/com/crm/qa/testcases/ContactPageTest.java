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

public class ContactPageTest extends TestBase {
    LoginPage loginpage;
    HomePage homepage;
    LandingPage lp;
    ContactsPage contactspage;
    String sheetname= "contacts";
    public ContactPageTest(){
        super();
    }

    @BeforeMethod
    public void Setup(){
        initialization();
        lp=new LandingPage();
       loginpage= lp.VerifyLogin();
       loginpage=new LoginPage();
      homepage= loginpage.VerifyHomePage(prop.getProperty("username"), prop.getProperty("password"));
      homepage=new HomePage();
     contactspage= homepage.AddContactPage();
      contactspage=new ContactsPage();
    }
    @Test(priority = 1)
    public void ValidateConTitleTest(){
     String C1= contactspage.GetConTitle();
     System.out.println(C1);
        Assert.assertEquals(C1,"Cogmento CRM");
    }
    @DataProvider
    public Object[][] ValidateGetTestDataTest(){
       Object[][] TData = TestUtil.GetTestData(sheetname);
       return TData;
    }
    @Test(priority = 2,dataProvider = "ValidateGetTestDataTest")
    public void ValidateCreateConTest(String nun,String nln,String mn){
        contactspage.CreateContact( nun, nln, mn);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
