package InterstingInfo;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.ERPUtil;

public class ERP {

    @Test
    public void testName() {

        Driver.getDriver().get("https://qa.fidexio.com");

        Driver.getDriver().findElement(By.id("login")).sendKeys("posmanager5@info.com");

        Driver.getDriver().findElement(By.id("password")).sendKeys("posmanager");

        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        BrowserUtils.sleep(5);

        Driver.getDriver().findElement(By.xpath("//a[@data-action-id='136']")).click();


        BrowserUtils.sleep(5);


        ERPUtil.clickWithLocation("10:00","Tue 08/15/2023");
        BrowserUtils.sleep(5);

        //input[@class='o_input']

        Driver.getDriver().findElement(By.xpath("//input[@class='o_input']")).sendKeys("Test from Automation");
        BrowserUtils.sleep(5);

        //span[text()='Create']
        Driver.getDriver().findElement(By.xpath("//span[text()='Create']")).click();
        BrowserUtils.sleep(5);

        Driver.closeDriver();
    }
}
