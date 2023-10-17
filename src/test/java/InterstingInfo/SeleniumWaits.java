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
    public void implicitWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebElement added = driver.findElement(By.id("box0"));

    }

    @Test
    public void explicit(){
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
}
