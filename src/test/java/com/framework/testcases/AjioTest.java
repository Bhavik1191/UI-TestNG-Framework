package com.framework.testcases;


import com.framework.DriverFactory;
import com.framework.ajioPages.HomePage;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.rmi.server.ExportException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AjioTest {

    public static WebDriver driver;

  //  @Parameters({"browserType"})
    @BeforeTest
    public void start()
    {

        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.init_browser("chrome");
      //  driver = driverFactory.init_browser_browserStack();
    }

    @Test()
    public void SelectMenShirt()
    {
        driver.get("https://www.ajio.com");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearch();
        homePage.clickOnShirts();


        homePage.clickOnBoys();
        homePage.clickOnShirtsCb();


        String itemsCountTxt = homePage.getItemsCountTxt();
        int count = getIntFromString(itemsCountTxt);

        System.out.println("Total shirts found : "+count);

        List<WebElement> offerPriceList = homePage.getListOfferPrice();

        //Assigning maximum integer value
        int min=2147483647;
        for (WebElement offerPrice : offerPriceList) {


            int price = getIntFromString(offerPrice.getText());
            min = Math.min(min,price);
        }

        System.out.println("Lowest amount in list : "+min);

    }


    @Test
    public void openShirtNewWindow()
    {
        driver.get("https://www.ajio.com");
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSearch();
        homePage.clickOnShirts();

        String parentWindow = driver.getWindowHandle();


        homePage.clickOnFirstShirt();
        String childWindow = driver.getWindowHandle();

        driver.switchTo().window(parentWindow);
        homePage.clickOnSecondShirt();


        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> it = allWindow.iterator();

        while (it.hasNext())
        {
            String nextWindow = it.next();

           if(nextWindow.equalsIgnoreCase(childWindow))
           {
               System.out.println("you are in one");
               driver.switchTo().window(nextWindow);
           }
        }
        driver.switchTo().window(parentWindow);
    }



    public int getIntFromString(String input)
    {
        String count = "";
        for (int i = 0; i < input.length(); i++) {
            try
            {
                count = count + Integer.parseInt(input.charAt(i)+"");
            }
            catch (Exception e)
            {
            }
        }
        return Integer.parseInt(count);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
