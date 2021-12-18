package com.framework.testcases;


import com.framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AjioTest {

    public static WebDriver driver;

    @BeforeTest
    public void start()
    {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_browser("chrome");
    }

    @Test
    public void SelectMenShirt()
    {
        driver.get("https://www.ajio.com");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
