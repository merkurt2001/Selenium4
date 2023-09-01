package InterstingInfo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.Diff;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

import java.io.File;
import java.io.IOException;


public class AylinTask {

    static int a=1;
    String globalFilePath1;

    @Test
    public void Test1() throws IOException {

        Driver.getDriver().get("https://www.google.com/");
        Driver.getDriver().findElement(By.id("L2AGLb")).click();
        BrowserUtils.sleep(2);


        File scrFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String filePath1="wholePage"+a++;
        globalFilePath1=filePath1;
        FileUtils.copyFile(scrFile, new File("./"+filePath1 +".png"));


    //

        Driver.closeDriver();


    }

    @Test
    public void Test2() throws IOException {

        Driver.getDriver().get("https://www.google.com/");
        Driver.getDriver().findElement(By.id("L2AGLb")).click();
        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("java");


        File scrFile = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);

        String filePath2="wholePage"+a++;
        FileUtils.copyFile(scrFile, new File("./"+filePath2 +".png"));


        Driver.closeDriver();

        Driver.getDriver().get("https://www.diffchecker.com/image-compare/");

        Driver.getDriver().findElement(By.xpath("(//input)[1]")).sendKeys(System.getProperty("user.dir")+"/"+globalFilePath1+".png");
        Driver.getDriver().findElement(By.xpath("(//input)[3]")).sendKeys(System.getProperty("user.dir")+"/"+filePath2+".png");


        Driver.getDriver().findElement(By.xpath("//div/button[4]")).click();

        WebElement difference = Driver.getDriver().findElement(By.xpath("//*[@id=\"displayArea\"]/div/div/div[2]"));

        File scrFile1 = difference.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("./difference.png"));



    }


}

