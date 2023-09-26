package Selenium4_Features;


import org.junit.Test;
import utilities.BrowserUtils;
import utilities.Driver;

public class MinimizeTest {


    @Test
    public void test01() {


        Driver.getDriver().get("https://www.amazon.com"); // go to amazon

        BrowserUtils.sleep(3);

        Driver.getDriver().manage().window().minimize(); // minimize

        BrowserUtils.sleep(3);

        Driver.getDriver().manage().window().maximize(); // maximize

        BrowserUtils.sleep(3);

        Driver.closeDriver();


    }
}
