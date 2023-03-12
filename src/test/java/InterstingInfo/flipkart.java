package InterstingInfo;


import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class flipkart extends TestBase {


    @Test
    public void challenge1() {

       /* First Challenge: ============================🧐
        I want you to
        -  Go to https://www.flipkart.com/
        - Locate Wire Headphones*/


        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//div//button[@class='_2KpZ6l _2doB4z']")).click();

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[text()='Electronics']"))).perform();
        BrowserUtils.sleep(2);

        driver.findElement(By.xpath("//div[@class='_3XS_gI']//a[3]")).click();


    }


    @Test
    public void challenge2() {

        /*Second challenge =====
         - Go to  https://www.flipkart.com/
         - Click on the search box
         - Locate t-shirts*/

        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//div//button[@class='_2KpZ6l _2doB4z']")).click();

        driver.findElement(By.xpath("//div[@class='_3OO5Xc']")).click();

        BrowserUtils.sleep(2);

        driver.findElement(By.xpath("//li[@class='Y5N33s'][4]")).click();


    }


}
