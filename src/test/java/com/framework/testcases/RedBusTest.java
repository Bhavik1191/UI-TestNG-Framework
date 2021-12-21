package com.framework.testcases;

import com.framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RedBusTest {

    public static WebDriver driver;

    @Parameters("browserType")
    @BeforeTest
    public void start(String browserType)
    {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_browser(browserType);
    }

    @Test
    public void openRedbus()
    {
        driver.get("https://www.redbus.com");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
