package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class captureConsoleLogs {
    /**
     * Then, we add a listener to capture all the console logs logged by the application.
     * For each log captured by the application we then extract the log text with getText()
     * and log level with getLevel() methods.
     * <p>
     * While testing and working on an application with specific data or specific conditions,
     * logs help us in debugging and capturing the error messages, giving more insights
     * that are published in the Console tab of the Chrome DevTools.
     */

    DevTools devTools;
    ChromeDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // not polymorphic way
        driver.manage().window().maximize();
        devTools = driver.getDevTools();

        //Session of ChromeDevTool
        devTools.createSession();
    }

    @AfterMethod
    public void tearDown() {
        devTools.close();
        driver.quit();
    }

    @Test
    public void consoleLogTest() {
        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    System.out.println("log: " + logEntry.getText());
                    System.out.println("level: " + logEntry.getLevel());
                });
        driver.get("https://testersplayground.herokuapp.com/console-5d63b2b2-3822-4a01-8197-acd8aa7e1343.php");
    }


}



