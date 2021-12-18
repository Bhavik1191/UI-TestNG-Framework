package com.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Locale;

public class DriverFactory {


    public static WebDriver driver;
    //Create a method which returns driver object based on browser type parameter passed


    /**
     * Pass chrom, firefox etc and get the webdriver object
     * @param browser
     * @return
     */
    public WebDriver init_browser(String browser)
    {


        switch (browser.toLowerCase(Locale.ROOT))
        {
            case("chrome"):
                WebDriverManager.chromedriver().setup();
                ChromeOptions ChromeOptions = new ChromeOptions();
                ChromeOptions.setHeadless(false);
                driver = new ChromeDriver(ChromeOptions);
                break;

            case ("firefox"):
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(false);
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:
                driver = null;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        return driver;
    }

}



