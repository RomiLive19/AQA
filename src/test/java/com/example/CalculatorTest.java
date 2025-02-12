import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
        caps.setCapability(MobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        caps.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testAddition() {
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();

        String result = driver.findElementById("com.google.android.calculator:id/result").getText();
        assertEquals("5", result, "Результат сложения неверный!");
    }

    @Test
    public void testSubtraction() {
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();

        String result = driver.findElementById("com.google.android.calculator:id/result").getText();
        assertEquals("2", result, "Результат вычитания неверный!");
    }

    @Test
    public void testMultiplication() {
        driver.findElementById("com.google.android.calculator:id/digit_4").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_3").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();

        String result = driver.findElementById("com.google.android.calculator:id/result").getText();
        assertEquals("12", result, "Результат умножения неверный!");
    }

    @Test
    public void testDivision() {
        driver.findElementById("com.google.android.calculator:id/digit_8").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();


        String result = driver.findElementById("com.google.android.calculator:id/result").getText();
        assertEquals("4", result, "Результат деления неверный!");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}