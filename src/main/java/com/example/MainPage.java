package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    private By productAddToCartButton = By.cssSelector(".goods-card__add-to-cart");
    private By cartIcon = By.cssSelector(".cart-icon");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(int index) {
        List<WebElement> addButtons = driver.findElements(productAddToCartButton);
        if (index < addButtons.size()) {
            addButtons.get(index).click();
        }
    }

    public CartPage goToCart() {
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }
}
