package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    // you can not do like this, if consructor is private Driver obj = new Driver();
    private  Driver (){

    }
    public static WebDriver get() {
        //if webdriver object was not created yet
        if (driver == null) {
            //create webdriver object based on browser value from properties file
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(false); // if you want to run without interface (opening browser), change to "true'
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    //if browser type is wrong,  throw exception and no browser will be opened
                    throw new RuntimeException("Wrong browser type!");
            }
        }
        //if webdriver object was created- you can use it
        return driver;
    }

    public static void close(){
        //if driver still exist
        if(driver !=null){
            //close all browsers
            driver.quit();
            //destroy driver object, ready for garbage collector
            driver = null;
        }
    }
}
