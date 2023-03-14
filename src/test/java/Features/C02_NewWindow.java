package Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.Driver;


public class C02_NewWindow {

    @Test
    public void test01() throws InterruptedException {

        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().get("https://www.amazon.com");//go to Amazon
        Thread.sleep(3000);

        String firstPageHandleValue = Driver.getDriver().getWindowHandle();//get the handle value of the page

        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://www.facebook.com");//open new TAB and go to facebook

        Thread.sleep(3000);

        Driver.getDriver().switchTo().window(firstPageHandleValue);//go back to previous page-Amazon
        Thread.sleep(3000);


        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW).get("https://www.ebuy.com");//Open new window and go to ebuy
        Thread.sleep(3000);

        Driver.getDriver().switchTo().window(firstPageHandleValue);//open Amazon page again
        Thread.sleep(3000);

        Driver.closeDriver();



    }
}
