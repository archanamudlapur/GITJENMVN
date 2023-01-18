package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {
    @FindBy(xpath="//input[@name='first_name']")
    WebElement NewUserName;
    @FindBy(xpath = "//input[@name='last_name']")
    WebElement NewLastName;
    @FindBy(xpath="//button[text()='Save']")
    WebElement SaveBtn;
    @FindBy(xpath="//button[text()='Create']")
    WebElement Create;
    @FindBy(xpath="//input[@type='text' and @name='middle_name' ]")
    WebElement MiddleName;

    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }
    public String GetConTitle(){
      return driver.getTitle();
    }
    public void CreateContact(String nun,String nln,String mn){
        Create.click();
        NewUserName.sendKeys(nun);
        NewLastName.sendKeys(nln);
        MiddleName.sendKeys(mn);
        SaveBtn.click();
    }

}
