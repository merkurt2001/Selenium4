package InterstingInfo;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;


public class challanges {


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

    @Test
    public void challenge3() {

        /*Third Challenge--->    Please try to click on the "Shop now" button with Selenium.

https://www.mercedes-benz.co.uk/passengercars.html?group=all&subgroup=all.hatchback&view=BODYTYPE*/


        Driver.getDriver().get("https://www.mercedes-benz.co.uk/passengercars.html?group=all&subgroup=all.hatchback&view=BODYTYPE");

        Driver.getDriver().findElement(By.cssSelector(".webcomponent.aem-GridColumn.aem-GridColumn--default--12.owc-image-stage-host")).getShadowRoot().findElement(By.cssSelector(".owc-stage-cta-buttons__button.wb-button.wb-button--medium.wb-button--large.wb-button--primary.owc-stage-cta-buttons__button--primary")).click();


    }

    @Test
    public void ListOfLocatorTest(){

        Driver.getDriver().get("https://qa.navfort.com/");
        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys("storemanager51");
        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        Driver.getDriver().findElement(By.name("_submit")).click();
        BrowserUtils.sleep(7);

        List<WebElement> menuList = Driver.getDriver().findElements(By.xpath("(//*[@*='title title-level-1'])"));

        WebElement lastElement = menuList.get(menuList.size()-1);

        lastElement.click();
    }


}
