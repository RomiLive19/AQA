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
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Номер телефона']")
        ));
        phoneInput.sendKeys(phoneNumber);

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='Сумма']")
        ));
        amountInput.sendKeys("5");

        WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(), 'Продолжить')]")
        ));
        continueButton.click();
    }
}