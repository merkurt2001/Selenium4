package InterstingInfo;


import Base.TestBase;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Duration;

public class shadowRoot extends TestBase {

    @Test
    public void challenge3() {

       /*  Please try to write your name inside the doctor name input box with Selenium on this webpage. Good luck

            https://www.alodokter.com/*/


        Driver.getDriver().get("https://www.alodokter.com/");

        //Using JS Codes -- if you are using version lower than Selenium 4
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //Shadow Root - Open
        String str = "document.querySelector(\"hero-view\").shadowRoot.querySelector(\"#searchSpecialities\")";
        js.executeScript(str);

        //How to get text of the webElement with JS code if you may need any time later
        //String getMyElementText = "return document.querySelector(\"hero-view\").shadowRoot.querySelector(\"h1.hero-title\").textContent";
        String text = (String) js.executeScript("return document.querySelector(\"hero-view\").shadowRoot.querySelector(\"h1.hero-title\").textContent");
        System.out.println("My web element text = " + text);


    }


    @Test
    public void challenge4() {

       /*  try to click on "Buy online" button with Selenium (This is the real task of Cydeo Student from Mercedes Company). Good Luck...

           https://www.mercedes-benz.co.uk/passengercars.html?group=all&subgroup=all.hatchback&view=BODYTYPE */


        Driver.getDriver().get("https://www.mercedes-benz.co.uk/passengercars.html?group=all&subgroup=all.hatchback&view=BODYTYPE");

        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtils.sleep(3);
        //Shadow Root - Open
        //String str = "document.querySelector(\"body > cmm-cookie-banner\").shadowRoot.querySelector(\"div > div > div.cmm-cookie-banner__content > cmm-buttons-wrapper > div > div > wb7-button.button.button--accept-all.wb-button.hydrated\").click()";
        //js.executeScript(str);

        Driver.getDriver().findElement(By.cssSelector("body > cmm-cookie-banner")).getShadowRoot().findElement(By.cssSelector("div > wb7-button.button.button--accept-all.wb-button.hydrated")).click();


    }


    @Test
    public void challenge5() {

       /*open shadow example
          https://letcode.in/shadow */


        Driver.getDriver().get("https://letcode.in/shadow");
        BrowserUtils.sleep(1);

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //The first element that we would be locating is the "shadow_host" which is open-shadow  by using locator strategy – id.
        WebElement element = Driver.getDriver().findElement(By.id("open-shadow"));

        //Next we search for the first Shadow Root in the DOM next to it. For this, we have used the SearchContext interface.
        SearchContext shadowRoot = element.getShadowRoot();

        // The Shadow Root is returned using the getShadowRoot() method. If you check in the page, #shadow-root (open) is next to the "shadow_host".
        //For locating the input box there is only one Shadow DOM element we need to get through.The following line of code helps us get the Shadow root element.
        WebElement shadowElement = shadowRoot.findElement(By.cssSelector("#fname"));

        shadowElement.sendKeys("Maximilian");


    }

    @Test
    public void challenge6() {

       /*open shadow chain example
          https://letcode.in/shadow */


        Driver.getDriver().get("https://letcode.in/shadow");
        BrowserUtils.sleep(1);

        //First, we would be locating the shadow_host element by using its id, after which we would get the Shadow Root element using the getShadowRoot() method.
        //Next, We would get the Shadow Root element using the getShadowRoot() method.
        //Finally, we would sendkeys to the input box
        WebElement openShadowElement = Driver.getDriver().findElement(By.id("open-shadow")).getShadowRoot().findElement(By.cssSelector("#fname"));
        openShadowElement.sendKeys("max");


    }


    @Test
    public void challenge7() {

       //How to handle closed Shadow element

        Driver.getDriver().get("https://letcode.in/shadow");
        BrowserUtils.sleep(1);
        //Locate the closest element which is outside closed shadow root. It could be the host element for that shadow root.
        WebElement element = Driver.getDriver().findElement(By.id("close-shadow"));

        //Now focus on this outside element by using click() method
        element.click();

        //Now use Actions class to press the TAB key to focus on the closed shadow root element.
        Actions act = new Actions(Driver.getDriver());
        act.sendKeys(Keys.TAB).perform();

        //Now use Actions class to perform any action on the closed shadow dom element like sendKeys() or click() etc.
        act.sendKeys("maximilian@gmail.com").perform();


    }
}
