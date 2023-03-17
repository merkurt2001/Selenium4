package Base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserUtils;

import java.time.Duration;

    public abstract class TestBase {


        public static DevTools devTools;
        public static ChromeDriver driver;
        @BeforeMethod
        public void setUpMethod() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options); // not in polymorphic way
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            devTools = driver.getDevTools(); //devtool obj

            //Session of ChromeDevTool
            devTools.createSession();


        }

        @AfterMethod
        public void teardownMethod() {
            BrowserUtils.sleep(3);

            //driver.close();
        }


}
