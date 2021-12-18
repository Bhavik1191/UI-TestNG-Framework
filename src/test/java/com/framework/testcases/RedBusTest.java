package com.framework.testcases;

import com.framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBusTest {

    public static WebDriver driver;

    @BeforeTest
    public void start()
    {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_browser("chrome");
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
