package com.framework.ajioPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private static WebDriver driver;


    @FindBy(name = "searchVal")
    private static WebElement searchTb;

    @FindBy(linkText = "/search/?text=shrits")
    private static WebElement shirtsBtn;

    @FindBy(xpath = "//input[@id='Boys - Shirts']/following-sibling::label")
    private static WebElement categoryShirtCb;

    @FindBy(xpath = "//div[@class='filter']/div[1]")
    private static WebElement itemsFoundTxt;

    @FindBy(className = "offer-pricess")
    private static List<WebElement> offerPrices;

    @FindBy(xpath = "//div[@class='items']//div[contains(@class,'products-list__item ite')][1]")
    private static WebElement firstShrit;

    @FindBy(xpath = "//div[@class='items']//div[contains(@class,'products-list__item ite')][2]")
    private static WebElement secondShirt;


    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public void clickOnSearch()
    {

        searchTb.click();
    }


    public void clickOnShirts()
    {
        driver.findElement(By.xpath("//li[a[(@class='search-suggestionList ')]][7]")).click();
    }

    public void clickOnBoys()
    {
        driver.findElement(By.xpath("//input[@id='Boys']/following-sibling::label")).click();

        //WebElement element = driver.findElement(By.id("Boys").hashCode();

    }

    public void clickOnShirtsCb()
    {
        categoryShirtCb.click();
    }

    public String getItemsCountTxt()
    {
       return itemsFoundTxt.getText();
    }

    public List<WebElement> getListOfferPrice() {
        return offerPrices;
    }

    public void clickOnFirstShirt()
    {
        firstShrit.click();
    }

    public void clickOnSecondShirt() {
        secondShirt.click();
    }
}
