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

        Driver.getDriver().findElement(By.xpath("//span[@role='button']")).click();
        new Actions(Driver.getDriver()).moveToElement(Driver.getDriver().findElement(By.xpath("//div[@aria-label='Electronics']"))).perform();
        Driver.getDriver().findElement(By.xpath("//a[.='Wired Headphones']")).click();



    }


    @Test
    public void challenge2() {

        /*Second challenge =====
         - Go to  https://www.flipkart.com/
         - Click on the search box
         - Locate t-shirts*/

        Driver.getDriver().get("https://www.flipkart.com/");

        Driver.getDriver().findElement(By.xpath("//span[@role='button']")).click();

        Driver.getDriver().findElement(By.xpath("//input[@class='Pke_EE']")).click();

        BrowserUtils.sleep(3);

        Driver.getDriver().findElement(By.xpath("(//div[@class='YGcVZO'])[3]")).click();


    }


}
