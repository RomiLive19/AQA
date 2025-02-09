package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsByPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MtsByPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPlaceholder(By locator) {
        return driver.findElement(locator).getAttribute("placeholder");
    }

    public String getBlockTitle() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(), 'Онлайн пополнение') or contains(text(), 'без комиссии')]")
        ));
        return title.getAttribute("innerHTML")
                .replace("<br>", " ")
                .replace("&nbsp;", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }

    public boolean arePaymentLogosPresent() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        return !logos.isEmpty();
    }

    public void clickDetailsLink() {
        WebElement detailsLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        detailsLink.click();
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    public void fillFormAndContinue(String phoneNumber) {
        try {
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Номер телефона']")
            ));
            phoneInput.sendKeys(phoneNumber);

            WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Сумма']")
            ));
            amountInput.sendKeys("5");

            try {
                WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cookie__wrapper")));
                if (cookieBanner.isDisplayed()) {
                    WebElement closeButton = cookieBanner.findElement(By.cssSelector(".cookie__cancel"));
                    closeButton.click();
                    System.out.println("Cookie banner closed");
                }
            } catch (Exception e) {
                System.out.println("No banner");
            }

            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Продолжить')]")
            ));
            continueButton.click();

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'pay-description__cost')]/span[1]")
            ));
            System.out.println("Amount element is visible: " + amount.getText());

        } catch (Exception e) {
            System.out.println("Error occurred while filling form and continuing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}