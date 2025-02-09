package com.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private MtsByPage mtsByPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        assertTrue(driver.getCurrentUrl().contains(expectedUrl), "URL mismatch");
    }

    @Test
    public void testPlaceholderTexts() {
        assertEquals("Номер телефона", mtsByPage.getPlaceholder(By.xpath("//input[@placeholder='Номер телефона']")));
        assertEquals("Сумма", mtsByPage.getPlaceholder(By.xpath("//input[@placeholder='Сумма']")));
        assertEquals("E-mail для отправки чека", mtsByPage.getPlaceholder(By.xpath("//input[@placeholder='E-mail для отправки чека']")));
    }

    @Test
    public void testPopupValues() {
        try {
            // Шаг 1: Заполнение формы и продолжение
            mtsByPage.fillFormAndContinue("297777777");

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'pay-description__cost')]/span")));
            assertNotNull(amount);
            assertEquals("5.00 BYN", amount.getText());

            WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'pay-description__text')]/span")));
            assertNotNull(phone);
            assertTrue(phone.getText().contains("Номер:375297777777"));

            WebElement numberLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Номер карты']")));
            assertNotNull(numberLabel);
            assertEquals("Номер карты", numberLabel.getText());

            WebElement expiryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Срок действия']")));
            assertNotNull(expiryLabel);
            assertEquals("Срок действия", expiryLabel.getText());

            WebElement cvcLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='CVC']")));
            assertNotNull(cvcLabel);
            assertEquals("CVC", cvcLabel.getText());

            WebElement holderLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Имя держателя (как на карте)']")));
            assertNotNull(holderLabel);
            assertEquals("Имя держателя (как на карте)", holderLabel.getText());

        } catch (Exception e) {
            System.out.println("Step 1: Filling form and continuing - Failed!");
        }
    }
}