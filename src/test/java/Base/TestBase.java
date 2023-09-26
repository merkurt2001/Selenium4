package Base;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import utilities.BrowserUtils;

import java.time.Duration;

    public abstract class TestBase {


        public static DevTools devTools;
        public static ChromeDriver driver;
        @BeforeEach
        public void setUpMethod() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
//            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options); // not in polymorphic way
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            devTools = driver.getDevTools(); //devtool obj

            //Session of ChromeDevTool
            devTools.createSession();


        }

        @AfterEach
        public void teardownMethod() {
            BrowserUtils.sleep(3);

            //driver.close();
        }


}
