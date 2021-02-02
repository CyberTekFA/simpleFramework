package com.mystore.drivers;

import com.mystore.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;
    private static final int TimeOut = 20;
    private static final int PageLoadTimeOut = 50;
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal();

    private Driver() {
    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.getBrowserInstance(ConfigurationReader.getInstance().getProperty("browser"));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PageLoadTimeOut));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeOut));
            threadLocal.set(driver);
        }
        return threadLocal.get();
    }

    public static void closeDriver(){
        if (driver != null){
            threadLocal.get().quit();
            driver = null;
        }
    }
}
