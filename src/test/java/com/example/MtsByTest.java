package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTest {
    private WebDriver driver;
    private MtsByPage mtsByPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
        mtsByPage = new MtsByPage(driver);
        driver.get("https://www.mts.by");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        String expectedTitle = "Онлайн пополнение без комиссии";
        String actualTitle = mtsByPage.getBlockTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testPaymentLogos() {
        assertTrue(mtsByPage.arePaymentLogosPresent());
    }

    @Test
    public void testDetailsLink() {
        String expectedUrl = "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        mtsByPage.clickDetailsLink();
        assertTrue(driver.getCurrentUrl().contains(expectedUrl), "URL: " + expectedUrl);
    }

    @Test
    public void testContinueButton() {
        mtsByPage.fillFormAndContinue("297777777");
    }
}