package InterstingInfo;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowRoot {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://letcode.in/shadow");
        Thread.sleep(500);

//        String str="return document.querySelector(\"#open-shadow\").shadowRoot.querySelector(\"#fname\").value='hello'";
//
//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        js.executeScript(str);

        Shadow shadow=new Shadow(driver);
        WebElement element=shadow.findElement("#fname");
        element.sendKeys("merhaba");




    }

}
