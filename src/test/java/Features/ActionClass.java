package Features;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass {
    /*In Selenium 4, several new methods have been added to the Actions class:

click(WebElement)
This method is added to Actions class to replace the moveToElement(onElement).click().
 It is used to click on a certain web element.

clickAndHold(WebElement)
This method will replace the moveToElement(onElement).clickAndHold().
It is used to click on an element without releasing the click.

contextClick(WebElement)
This method will replace moveToElement(onElement).contextClick().
It will perform the right click operation.

doubleClick(WebElement)
This method is added to replace moveToElement(element).doubleClick().
It will perform a double click on an element.

release()*/
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test
    public void actionSelenium4() throws InterruptedException {
        driver.findElement(By.xpath("//*[.='Acepto']")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("java");
        Thread.sleep(3000);
        //Selenium 4 --code is now shorter
        Actions actions = new Actions(driver);
        //double click
        Thread.sleep(3000);
        actions.moveToElement(searchBox).click().build().perform();
        Thread.sleep(3000);
        actions.doubleClick(searchBox).perform();
        //right click
        Thread.sleep(3000);
        actions.contextClick(searchBox).perform();

    }
    @Test
    public void actionSelenium3() throws InterruptedException {
        driver.findElement(By.xpath("//*[.='Acepto']")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("java");
        Thread.sleep(3000);
        //Selenium 3
        Actions actions = new Actions(driver);
        //double click
        Thread.sleep(3000);
        actions.moveToElement(searchBox).doubleClick().build().perform();
        //right click
        Thread.sleep(3000);
        actions.moveToElement(searchBox).contextClick().build().perform();
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
