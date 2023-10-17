package InterstingInfo;

import Base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;


import java.time.Duration;

public class SeleniumWaits extends TestBase {
    @Test
    public void implicitWait1() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebElement added = driver.findElement(By.id("box0"));

    }

    @Test
    public void implicitWait2() {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //waits for the page to load for a specified number of seconds
//pageLoadTimeout command is essential in performance-related testing.
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebElement added = driver.findElement(By.id("box0"));

    }

    @Test
    public void implicitWait3() {

        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebElement added = driver.findElement(By.id("box0"));

    }

    @Test
    public void explicit() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement revealed = driver.findElement(By.id("revealed"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.findElement(By.id("reveal")).click();
        wait.until(d -> revealed.isDisplayed());

        revealed.sendKeys("Displayed");
        Assertions.assertEquals("Displayed", revealed.getDomProperty("value"));
    }

    @Test
    public void fluent() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement revealed = driver.findElement(By.id("revealed"));
        FluentWait<ChromeDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        driver.findElement(By.id("reveal")).click();
        wait.until(d -> {
            revealed.sendKeys("Displayed");
            return true;
        });

        Assertions.assertEquals("Displayed", revealed.getDomProperty("value"));
    }

    @Test
    public void explicit2() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement revealed = driver.findElement(By.id("revealed"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("reveal")).click();
        wait.until(ExpectedConditions.visibilityOf(revealed));

        revealed.sendKeys("Displayed");
        Assertions.assertEquals("Displayed", revealed.getDomProperty("value"));

    }

    @Test
    public void explicit3() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        WebElement reveal = driver.findElement(By.id("reveal"));
        reveal.click();

        try {
            WebElement revealed = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("revealed"))));
            revealed.sendKeys("Hello");
            Assertions.assertEquals("Hello", revealed.getDomProperty("value"));
        } catch (Exception e) {
            System.out.println("element does not exist");
        } finally {
            driver.quit();
        }


    }
}
