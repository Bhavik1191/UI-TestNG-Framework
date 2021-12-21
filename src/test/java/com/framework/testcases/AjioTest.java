package com.framework.testcases;


import com.framework.DriverFactory;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class AjioTest {

    public static WebDriver driver;

    @Parameters("browserType")
    @BeforeTest
    public void start(String browserType)
    {

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_browser(browserType);
    }

    @DataProvider(name = "test Data")
    public Object[][] testData()
    {
        return new Object[][]{{"test date 1"},{"test data 2"}};
    }

    @Test()
    public void SelectMenShirt()
    {
        driver.get("https://www.ajio.com");
        System.out.println("Print Test data" );
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
