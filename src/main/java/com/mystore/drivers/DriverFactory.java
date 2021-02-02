package com.mystore.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static final Supplier<WebDriver> getChrome = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return new ChromeDriver(options);
    };
    private static final Supplier<WebDriver> getChromeHeadless = () -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setHeadless(true);
        return new ChromeDriver(options);
    };

    private static final Supplier<WebDriver> getFirefox = () -> {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return new FirefoxDriver(options);
    };

    private static final Supplier<WebDriver> getEdge = () -> {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return new EdgeDriver(options);
    };
    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome", getChrome);
        MAP.put("firefox", getFirefox);
        MAP.put("edge", getEdge);
        MAP.put("chrome_headless",getChromeHeadless);
    }

    public static WebDriver getBrowserInstance(String key) {
        return MAP.get(key).get();
    }
}
