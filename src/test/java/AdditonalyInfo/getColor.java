package AdditonalyInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class getColor {
    public static void main(String[] args) {
        //using shadow dependecy....
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://qa.intabella.com");
        WebElement submit = driver.findElement(By.id("_submit"));
        String cssValue = submit.getCssValue("background-color");
        System.out.println(cssValue);

        String asHex = Color.fromString(cssValue).asHex();
        System.out.println(asHex);


    }
}
