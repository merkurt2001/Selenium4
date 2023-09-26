package InterstingInfo;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;


public class flipkart {



    @Test
    public void challenge1() {

       /* First Challenge: ============================🧐
        I want you to
        -  Go to https://www.flipkart.com/
        - Locate Wire Headphones*/



        Driver.getDriver().get("https://www.flipkart.com/");

        Driver.getDriver().findElement(By.xpath("//div//button[@class='_2KpZ6l _2doB4z']")).click();
        BrowserUtils.sleep(10);
        new Actions(Driver.getDriver()).moveToElement(Driver.getDriver().findElement(By.xpath("//div[text()='Electronics']"))).perform();
        BrowserUtils.sleep(10);

        Driver.getDriver().findElement(By.xpath("//div[@class='_3XS_gI']//a[3]")).click();



    }


    @Test
    public void challenge2() {

        /*Second challenge =====
         - Go to  https://www.flipkart.com/
         - Click on the search box
         - Locate t-shirts*/

        Driver.getDriver().get("https://www.flipkart.com/");

        Driver.getDriver().findElement(By.xpath("//div//button[@class='_2KpZ6l _2doB4z']")).click();

        Driver.getDriver().findElement(By.xpath("//div[@class='_3OO5Xc']")).click();

        BrowserUtils.sleep(2);

        Driver.getDriver().findElement(By.xpath("//li[@class='Y5N33s'][4]")).click();


    }


}
