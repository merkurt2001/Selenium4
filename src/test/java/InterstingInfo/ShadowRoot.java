package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRoot {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/shadow");
        Thread.sleep(2000);

        String str = "return document.querySelector(\"#open-shadow\").shadowRoot.querySelector(\"#fname\")";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#open-shadow').shadowRoot.querySelector('#fname').value='mustafa'", args);



    }

}
