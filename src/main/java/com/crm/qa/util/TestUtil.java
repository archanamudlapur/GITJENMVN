package com.crm.qa.util;

import com.crm.qa.base.TestBase;
import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class TestUtil extends TestBase {
   public static long pageloadtimeout=20;
    public static long implicitwait=20;
    public static String SpreadSheetPath="/Users/archanamudlapur/Documents/FreeCrmTest/src/main/java/com/crm/qa/TestData/FreeCrmTestData.xlsx";
    static Workbook book;
    static Sheet sheet;
    @FindBy(xpath = "//a[contains(text(),'CRM')]")
    WebElement CRMbtn;
    @FindBy(xpath = "//a[(text()='CRM for Any Business')]")
    WebElement CRMBusinessBtn;

    public TestUtil(){
        PageFactory.initElements(driver,this);
    }

    public  void ActionOnElement(){
        Actions action=new Actions(driver);
        action.moveToElement(CRMbtn).build().perform();
        CRMBusinessBtn.click();
    }

    public static Object[][] GetTestData(String sheetname){
        FileInputStream file=null;
        try{
            file=new FileInputStream(SpreadSheetPath);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try{
       book= WorkbookFactory.create(file);
        }
        catch (InvalidFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

       sheet = book.getSheet(sheetname);
      Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
      for(int i=0;i<sheet.getLastRowNum();i++){
      for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
          data[i][k]=sheet.getRow(i+1).getCell(k).toString();
      }
      }
        return data;

    }
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

}
