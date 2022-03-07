package Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class C01_Minimize {

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com"); // go to amazon

        Thread.sleep(3000);

        driver.manage().window().minimize(); // minimize

        Thread.sleep(5000);

        driver.manage().window().maximize(); // maximize

        Thread.sleep(5000);



    }
}
