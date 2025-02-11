package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By productNames = By.cssSelector(".cart-item__name");
    private By productQuantities = By.cssSelector(".cart-item__quantity");
    private By productPrices = By.cssSelector(".cart-item__price");
    private By totalAmount = By.cssSelector(".total-amount");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductQuantities() {
        return driver.findElements(productQuantities);
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    public int getTotalAmountValue() {
        String totalAmountText = getTotalAmount().getText().replaceAll("[^\\d]", "");
        return Integer.parseInt(totalAmountText);
    }
    public WebElement getTotalAmount() {
        return driver.findElement(totalAmount);
    }
}
