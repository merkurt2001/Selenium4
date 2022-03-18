package Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_TimeOuts_Duration {

    WebDriver driver;

    @Test
    public void test() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//selenium4

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//selenium3

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // WebDriverWait wait= new WebDriverWait(driver,20);
    }

}
