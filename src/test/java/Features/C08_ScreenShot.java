package Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;



public class C08_ScreenShot {

    WebDriver driver;

    @Test
    public void test01() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./wholePage.png"));

        File scrFile1 = aramaKutusu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("./searchBox.png"));
    }
}

