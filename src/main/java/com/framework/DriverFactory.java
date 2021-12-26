package com.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DriverFactory {


    public static WebDriver driver;

    public static final String USERNAME = "bhavikshah_NkGSvf";
    public static final String AUTOMATE_KEY = "MunQncX7ugTtDsZ489Ro";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public WebDriver init_browser_browserStack()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "75.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");

        // INIT CHROME OPTIONS
        ChromeOptions options = new ChromeOptions();
        Map< String, Object > prefs = new HashMap< String, Object >();
        Map < String, Object > profile = new HashMap < String, Object > ();
        Map < String, Object > contentSettings = new HashMap < String, Object > ();

        // SET CHROME OPTIONS
        // 0 - Default, 1 - Allow, 2 - Block
        contentSettings.put("geolocation", 1);
        profile.put("managed_default_content_settings", contentSettings);
        prefs.put("profile", profile);
        options.setExperimentalOption("prefs", prefs);

        // SET CAPABILITY
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        return driver;
    }
    //Create a method which returns driver object based on browser type parameter passed


    /**
     * Pass chrome, firefox etc and get the webdriver object
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
                ChromeOptions.addArguments("use-fake-ui-for-media-stream", "--disable-notifications");
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



