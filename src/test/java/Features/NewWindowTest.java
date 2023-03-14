package Features;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;


public class NewWindowTest {

    @Test
    public void test01() {

        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().get("https://www.amazon.com");//go to Amazon
        BrowserUtils.sleep(3);

        String firstPageHandleValue = Driver.getDriver().getWindowHandle();//get the handle value of the page

        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com");//open new TAB and go to facebook

        BrowserUtils.sleep(3);

        Driver.getDriver().switchTo().window(firstPageHandleValue);//go back to previous page-Amazon
        BrowserUtils.sleep(3);


        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW).get("https://www.ebuy.com");//Open new window and go to ebuy
        BrowserUtils.sleep(3);

        Driver.getDriver().switchTo().window(firstPageHandleValue);//open Amazon page again
        BrowserUtils.sleep(3);

        Driver.closeDriver();


    }
}
