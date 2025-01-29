package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void testSelenium() {
        // Укажите путь к драйверу ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/romi/Applications/Lesson_11_maven/chromedriver/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        assertEquals("Google", title);

        driver.quit();
    }
}
