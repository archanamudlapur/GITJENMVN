package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventlistener;
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/archanamudlapur/Documents/FreeCrmTest/src/main/java/com/crm/qa/config/Config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  public static void initialization()
    {
        String browsername= prop.getProperty("browser");
        if(browsername.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/archanamudlapur/Documents/FreeCrmTest/src/main/resources/chromedriver");
            driver=new ChromeDriver();
        }
        else {
            System.out.println("Sorry,browser not found");
        }
        e_driver=new EventFiringWebDriver(driver);
        eventlistener=new WebEventListener();
        e_driver.register(eventlistener);
        driver=e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtimeout,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
