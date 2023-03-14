package Features;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

import java.io.File;
import java.io.IOException;



public class C08_ScreenShot {


    @Test
    public void test01() throws InterruptedException, IOException {

        Driver.getDriver().get("https://www.amazon.com");

        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        File scrFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./wholePage.png"));

        File scrFile1 = aramaKutusu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("./searchBox.png"));
    }
}

