package com.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.*;

public class AddToCartTest {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.wildberries.ru");
    }

    @Test
    public void testAddMultipleItemsToCart() {
        MainPage mainPage = new MainPage(driver);

        mainPage.addProductToCart(0);
        mainPage.addProductToCart(1);

        CartPage cartPage = mainPage.goToCart();

        assertEquals(2, cartPage.getProductNames().size(), "Количество товаров в корзине должно быть 2");

        assertEquals("Товар 1", cartPage.getProductNames().get(0).getText(), "Название первого товара не совпадает");
        assertEquals("Товар 2", cartPage.getProductNames().get(1).getText(), "Название второго товара не совпадает");

        assertEquals("1", cartPage.getProductQuantities().get(0).getText(), "Количество первого товара неверное");
        assertEquals("1", cartPage.getProductQuantities().get(1).getText(), "Количество второго товара неверное");

        assertTrue(cartPage.getProductPrices().get(0).getText().matches("\\d+\\s*₽"), "Цена первого товара не совпадает");
        assertTrue(cartPage.getProductPrices().get(1).getText().matches("\\d+\\s*₽"), "Цена второго товара не совпадает");

        int totalAmountFromCart = cartPage.getTotalAmountValue();

        int expectedTotalAmount = 500 + 300;

        assertEquals(expectedTotalAmount, totalAmountFromCart, "Общая сумма товаров не совпадает");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
