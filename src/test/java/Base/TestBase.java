package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

    public abstract class TestBase {

        protected WebDriver driver;

        @BeforeMethod
        public void setUpMethod() {

            driver = Driver.getDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        }

        @AfterMethod
        public void teardownMethod() {
            BrowserUtils.sleep(3);
            driver.quit();
            //driver.close();
        }


}
