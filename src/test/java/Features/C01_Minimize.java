package Features;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Minimize {


    @Test
    public void test01() throws InterruptedException {


        Driver.getDriver().get("https://www.amazon.com"); // go to amazon

        Thread.sleep(3000);

        Driver.getDriver().manage().window().minimize(); // minimize

        Thread.sleep(5000);

        Driver.getDriver().manage().window().maximize(); // maximize

        Thread.sleep(5000);

        Driver.closeDriver();



    }
}
