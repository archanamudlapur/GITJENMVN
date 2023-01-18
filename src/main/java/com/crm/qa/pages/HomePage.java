package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath ="//span[text()='Contacts']")
    WebElement ContactsLink;


    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String GetHomeTitle(){
       return driver.getTitle();
    }

    public ContactsPage AddContactPage(){
        ContactsLink.click();
        return new ContactsPage();

    }
}
